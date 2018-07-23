package com.xhwl.po;

import javax.persistence.*;

@Table(name = "count_result_by_day")
public class CountResultByDay {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 统计日期
     */
    private String countdate;

    /**
     * 统计结果数量
     */
    private Long res;

    /**
     * 告警等级
     */
    @Column(name = "alarm_leve")
    private String alarmLeve;

    /**
     * 告警类型解释
     */
    @Column(name = "warning_type_explain")
    private String warningTypeExplain;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取统计日期
     *
     * @return countdate - 统计日期
     */
    public String getCountdate() {
        return countdate;
    }

    /**
     * 设置统计日期
     *
     * @param countdate 统计日期
     */
    public void setCountdate(String countdate) {
        this.countdate = countdate == null ? null : countdate.trim();
    }

    /**
     * 获取统计结果数量
     *
     * @return res - 统计结果数量
     */
    public Long getRes() {
        return res;
    }

    /**
     * 设置统计结果数量
     *
     * @param res 统计结果数量
     */
    public void setRes(Long res) {
        this.res = res;
    }

    /**
     * 获取告警等级
     *
     * @return alarm_leve - 告警等级
     */
    public String getAlarmLeve() {
        return alarmLeve;
    }

    /**
     * 设置告警等级
     *
     * @param alarmLeve 告警等级
     */
    public void setAlarmLeve(String alarmLeve) {
        this.alarmLeve = alarmLeve == null ? null : alarmLeve.trim();
    }

    /**
     * 获取告警类型解释
     *
     * @return warning_type_explain - 告警类型解释
     */
    public String getWarningTypeExplain() {
        return warningTypeExplain;
    }

    /**
     * 设置告警类型解释
     *
     * @param warningTypeExplain 告警类型解释
     */
    public void setWarningTypeExplain(String warningTypeExplain) {
        this.warningTypeExplain = warningTypeExplain == null ? null : warningTypeExplain.trim();
    }
}