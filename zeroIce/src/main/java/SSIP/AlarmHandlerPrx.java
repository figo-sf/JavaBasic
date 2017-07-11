// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `ssip_oa.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SSIP;

public interface AlarmHandlerPrx extends Ice.ObjectPrx
{
    public void onAlarm(AlarmMessage[] msglist);

    public void onAlarm(AlarmMessage[] msglist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_onAlarm(AlarmMessage[] msglist);

    public Ice.AsyncResult begin_onAlarm(AlarmMessage[] msglist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_onAlarm(AlarmMessage[] msglist, Ice.Callback __cb);

    public Ice.AsyncResult begin_onAlarm(AlarmMessage[] msglist, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_onAlarm(AlarmMessage[] msglist, Callback_AlarmHandler_onAlarm __cb);

    public Ice.AsyncResult begin_onAlarm(AlarmMessage[] msglist, java.util.Map<String, String> __ctx, Callback_AlarmHandler_onAlarm __cb);

    public void end_onAlarm(Ice.AsyncResult __result);

    public void onChangedSchedule(ScheduleMessage[] slist);

    public void onChangedSchedule(ScheduleMessage[] slist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_onChangedSchedule(ScheduleMessage[] slist);

    public Ice.AsyncResult begin_onChangedSchedule(ScheduleMessage[] slist, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_onChangedSchedule(ScheduleMessage[] slist, Ice.Callback __cb);

    public Ice.AsyncResult begin_onChangedSchedule(ScheduleMessage[] slist, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_onChangedSchedule(ScheduleMessage[] slist, Callback_AlarmHandler_onChangedSchedule __cb);

    public Ice.AsyncResult begin_onChangedSchedule(ScheduleMessage[] slist, java.util.Map<String, String> __ctx, Callback_AlarmHandler_onChangedSchedule __cb);

    public void end_onChangedSchedule(Ice.AsyncResult __result);
}