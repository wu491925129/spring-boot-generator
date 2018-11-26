package com.wulong.project.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author:wulong
 * @Date:2018/7/26 15:40
 * @mail:491925129@qq.com
 * 定时器管理器
 */
@Service
@Scope("singleton")
public class QuartzManager {

	/**
	 * 任务组名
	 */
	private static final String JOB_GROUP_NAME = "task_group";

	/**
	 * 触发器组名
	 */
	private static final String TRIGGER_GROUP_NAME = "task_trigger";

	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

	private static QuartzManager quartzManager = null;

	private QuartzManager() {

	}

	public static QuartzManager getInstance() {
		if (quartzManager == null) {
			synchronized (QuartzManager.class) {
				if (quartzManager == null) {
					quartzManager = new QuartzManager();
				}
			}
		}
		return quartzManager;
	}

	/**
	 * @Description: 添加一个定时任务
	 *
	 * @param jobName 任务名
	 * @param jobClass  任务
	 * @param cron   时间设置，参考quartz说明文档
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addJob(String jobName, Class jobClass, String cron) {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			// 任务名，任务组，任务执行类
			JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, JOB_GROUP_NAME).build();
			// 传参  任务主键
			jobDetail.getJobDataMap().put("taskId", jobName);
			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();
			// 调度容器设置JobDetail和Trigger
			sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 修改一个任务的触发时间
	 *
	 * @param jobName
	 * @param cron   时间设置，参考quartz说明文档
	 */
	public void changeJob(String jobName, String cron) {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}

			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				sched.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */
				/** 方式二：先删除，然后在创建一个新的Job  */
				//JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
				//Class<? extends Job> jobClass = jobDetail.getJobClass();
				//removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
				//addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
				/** 方式二 ：先删除，然后在创建一个新的Job */
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 移除一个任务
	 *
	 * @param jobName
	 */
	public void removeJob(String jobName) {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
			sched.pauseTrigger(triggerKey);// 停止触发器
			sched.unscheduleJob(triggerKey);// 移除触发器
			sched.deleteJob(JobKey.jobKey(jobName, JOB_GROUP_NAME));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:启动所有定时任务
	 */
	public void startJobs() {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			sched.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:关闭所有定时任务
	 */
	public void shutdownJobs() {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
