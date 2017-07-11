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

public interface AlarmServicePrx extends Ice.ObjectPrx
{
    public void initAlarmHandler(AlarmHandlerPrx proxy);

    public void initAlarmHandler(AlarmHandlerPrx proxy, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_initAlarmHandler(AlarmHandlerPrx proxy);

    public Ice.AsyncResult begin_initAlarmHandler(AlarmHandlerPrx proxy, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_initAlarmHandler(AlarmHandlerPrx proxy, Ice.Callback __cb);

    public Ice.AsyncResult begin_initAlarmHandler(AlarmHandlerPrx proxy, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_initAlarmHandler(AlarmHandlerPrx proxy, Callback_AlarmService_initAlarmHandler __cb);

    public Ice.AsyncResult begin_initAlarmHandler(AlarmHandlerPrx proxy, java.util.Map<String, String> __ctx, Callback_AlarmService_initAlarmHandler __cb);

    public void end_initAlarmHandler(Ice.AsyncResult __result);
}