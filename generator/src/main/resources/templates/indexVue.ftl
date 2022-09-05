<#--根据对象 生成属性列表-->
<#macro greet3 table>
     <#list table.fields as field>
            <#if field.keyFlag>
                <el-table-column prop="${field.propertyName}" label="${field.comment}" show-overflow-tooltip v-if="false"></el-table-column>
            <#else >
                <el-table-column prop="${field.propertyName}" label="${field.comment}" show-overflow-tooltip></el-table-column>
            </#if>
    </#list>
</#macro>
<template>
    <div class="container">
        <el-card shadow="hover">
            <template #header>
                <div class="header">
                    <el-button type="primary" size="small" icon="el-icon-plus" @click="onHandleAdd">增加</el-button>
                    <el-button type="danger" size="small" icon="el-icon-plus" @click="onHandleDeleteAll">批量删除</el-button>
                </div>
            </template>
            <el-table :data="tableData.data" stripe border style="width: 100%" @selection-change="onHandleSelectionChange">
                <el-table-column type="selection" width="55"> </el-table-column>
                <@greet3 table/>
                <el-table-column fixed="right" label="操作" width="120">
                    <template #default="scope">
                        <el-button size="mini" type="text" @click="onHandleRowEdit(scope.row)">修改</el-button>
                        <el-button size="mini" type="text" @click="onHandleRowDel(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    @size-change="onHandleSizeChange"
                    @current-change="onHandleCurrentChange"
                    class="mt15"
                    :pager-count="5"
                    :page-sizes="[10, 20, 30]"
                    :current-page="tableData.param.pageNum"
                    background
                    :page-size="tableData.param.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="tableData.total"
            >
            </el-pagination>
        </el-card>
        <Edit${entity} ref="editAddRef" :type="type" :reload="initTableData" />
    </div>
</template>

<script lang="ts">
    import {onMounted, reactive, ref, toRefs} from 'vue';

    import {ElMessage, ElMessageBox} from 'element-plus';
    import Edit${entity} from './edit';

    export default {
        name: 'equipment${entity}',
        components: { Edit${entity} },

        setup() {
            const editAddRef = ref();

            const state: any = reactive({
                type: 'add', // 操作类型
                multipleSelection: [], // 选中项
                tableData: {
                    data: [],
                    total: 0,
                    loading: false,
                    param: {
                        pageNum: 1,
                        pageSize: 10,
                    },
                },
            });
            // 初始化表格数据
            const initTableData = () => {
                state.tableData.loading = true;
                get${entity}List({
                    page: state.tableData.param.pageNum,
                    limit: state.tableData.param.pageSize,
                }).then((res) => {
                    state.tableData.loading = false;

                    state.tableData.data = res.data.records;
                    state.tableData.total = res.data.total;
                });
            };

            // 分页改变
            const onHandleSizeChange = (val: number) => {
                state.tableData.param.pageSize = val;
                initTableData();
            };
            // 分页改变
            const onHandleCurrentChange = (val: number) => {
                state.tableData.param.pageNum = val;
                initTableData();
            };
            // 页面加载时
            onMounted(() => {
                initTableData();
            });

            const onHandleAdd = () => {
                state.type = 'add';
                editAddRef.value.openDialog();
            };

            // 打开编辑菜单弹窗
            const onHandleRowEdit = (row: object) => {
                state.type = 'edit';
                editAddRef.value.openDialog(row);
            };

            // 批量删除
            const onHandleDeleteAll = () => {
                if (!state.multipleSelection.length) {
                    ElMessage.error('请选择项');
                    return;
                } else {
                    ElMessageBox.confirm('此操作将永久删除纪录, 是否继续?', '提示', {
                        confirmButtonText: '删除',
                        cancelButtonText: '取消',
                        type: 'warning',
                    })
                        .then(() => {})
                        .catch(() => {});
                }
            };

            // 选择项
            const onHandleSelectionChange = (val: any) => {
                state.multipleSelection = val;
            };
            // 当前行删除
            const onHandleRowDel = (row: any) => {
                ElMessageBox.confirm('此操作将永久删除纪录, 是否继续?', '提示', {
                    confirmButtonText: '删除',
                    cancelButtonText: '取消',
                    type: 'warning',
                })
                    .then(() => {
                        remove${entity}ById(row.${entity?uncap_first}Id).then((res: any) => {
                            ElMessage.info(res.msg);
                            initTableData();
                        });
                    })
                    .catch(() => {});
            };

            return {
                editAddRef,
                onHandleRowDel, // 删除单行
                onHandleDeleteAll, // 删除多行
                onHandleSizeChange, // 修改分页大小
                onHandleCurrentChange, // 修改分页页数
                onHandleRowEdit, //编辑单行
                onHandleAdd, // 新增
                onHandleSelectionChange, //选中
                initTableData, //暴露给子组件刷新数据
                ...toRefs(state),

            };
        },
    };
</script>
