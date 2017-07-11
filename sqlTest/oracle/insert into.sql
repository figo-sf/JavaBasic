CREATE OR REPLACE
PROCEDURE "CSMARM_P_DAY_STATS" AS
Begin

  insert into ALARM_T_DAY_STATS(ID, STATS_DAY, EQUID, ALARM_CODE, ALARM_CNT, RECORD_TIME)
    select
      sys_guid(), sysdate-1, ARM_EQU_CODE, ARM_CODE, count(ARM_UUID), sysdate
    from
      MMS_ALARM_ALL
    where
      ARM_HAPPEN_TIME<to_date(to_char(sysdate, 'YYYY-MM-DD'||' 00:00:00') , 'YYYY-MM-DD HH24:MI:SS')
    and ARM_HAPPEN_TIME>=to_date(to_char(sysdate-1, 'YYYY-MM-DD'||' 00:00:00') , 'YYYY-MM-DD HH24:MI:SS')
    and ARM_MEGER_BY is null
    and (arm_is_maintain is null or arm_is_maintain=0)
    group by
      ARM_EQU_CODE,
       ARM_CODE;

Commit;
End CsmArm_p_day_stats;
