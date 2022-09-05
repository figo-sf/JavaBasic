
// route.ts 中增加路径
{
path: '/equipment/${entity?uncap_first}',
name: 'equipment${entity}',
component: () => import('/@/views/equipment/${entity?uncap_first}/index.vue'),
meta: {
title: 'message.router.equipment${entity}',
isLink: '',
isHide: false,
isKeepAlive: true,
isAffix: false,
isIframe: false,
auth: ['admin'],
icon: 'el-icon-truck',
},
},

// route.ts 中增加路径