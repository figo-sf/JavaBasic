import request from '/@/utils/request';

//查询list
export function get${entity}List(params?: object) {
    return request({
        url: '/common/${entity?uncap_first}/list',
        method: 'post',
        params,
    });
}
//根据id删除
export function remove${entity}ById(params?: object) {
    return request({
        url: '/common/${entity?uncap_first}/remove${entity}ById/' + params,
        method: 'delete',
    });
}

//新增修改
export function au${entity}(params?: object) {
    return request({
        url: '/common/${entity?uncap_first}/au${entity}',
        method: 'post',
        data: params,
    });
}
