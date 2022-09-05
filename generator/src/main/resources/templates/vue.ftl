<#--根据类型生成表单-->
<#macro greet field>
    <el-col :xs="24" :sm="12" :md="12" :lg="12" :xl="12" class="mb20">
        <el-form-item label="${field.comment}">
            <#if field.propertyType =="LocalDateTime" >
                <el-date-picker v-model="ruleForm.${field.propertyName}" type="datetime" placeholder="选择日期"
                                style="width:100%"></el-date-picker>
            <#elseif field.propertyType =="LocalDate">
                <el-date-picker v-model="ruleForm.${field.propertyName}" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            <#else>
                <el-input v-model="ruleForm.${field.propertyName}" placeholder="请填入${field.comment}" clearable></el-input>
            </#if>
        </el-form-item>
    </el-col>
</#macro>
<#--根据对象 生成属性列表-->
<#macro greet2 table>
    <#list table.fields as field>
        ${field.propertyName}:'' ,//${field.comment}
    </#list>
</#macro>
<#macro greet5 table>
    <#list table.fields as field>
        ${field.propertyName} : row.${field.propertyName},
    </#list>
</#macro>
<template>
    <div class="container">
        <el-dialog :title="type == 'add' ? '添加' : '修改'" v-model="isShowDialog" width="769px"  :before-close="onHandleClose">
            <el-form :model="ruleForm" size="small" ref="formRef" label-width="80px">
            <#assign keySize=0/>
                <#list table.fields as field>
                    <#if field.keyFlag>
                        <el-input v-model="ruleForm.${field.propertyName}" placeholder="请填入ID" type="hidden"></el-input>
                        <#assign keySize=keySize+1 />
                    <#else>
                        <#if field.propertyName == "createTime"|| field.propertyName  == "modifyTime">
                            <#assign keySize=keySize+1 />
                        <#else>
                            <#if (field_index-keySize) % 2 == 0>
                            <el-row>
                                <@greet field/>
                                <#else>
                                <@greet field/>
                            </el-row>
                            </#if>
                        </#if>


                    </#if>
                </#list>
                <#if (table.fields?size -keySize)  % 2 == 1>
                    </el-row>
                </#if>
            </el-form>
            <template #footer>
				<span class="dialog-footer">
					<el-button @click="onCancel" size="small">取 消</el-button>
					<el-button type="primary" @click="onSubmitForm" size="small">提 交</el-button>
				</span>
            </template>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {reactive, ref, toRefs} from 'vue';
    import {ElMessage} from 'element-plus';
    import {au${entity}} from '/@/api/';
    export default {
        name: 'Edit${entity}',
        components: {},
        props: {
            type: String,
            reload: Function,
        },
        setup(props) {
            const formRef = ref();

            const state = reactive({
                isShowDialog: false,
                type: 'add',
                rules: {},
                ruleForm: {
                    <@greet2 table/>
                },
            });
            // 打开弹窗
            const openDialog = (row: any) => {
                state.isShowDialog = true;
                if (row) {
                    state.ruleForm = {
                        ...state.ruleForm,
                        <@greet5 table/>

                    };
                }
            };
            // 关闭弹窗
            const closeDialog = () => {
                state.isShowDialog = false;
            };

            // 取消
            const onCancel = () => {
                closeDialog();
                initForm();
            };
            // 新增
            const onSubmitForm = () => {
                formRef.value.validate((valid: any) => {
                    if (valid) {
                        if (props.type == 'add') {
                            ElMessage.success('添加成功');
                            state.isShowDialog = false;
                            au${entity}({
                                ...state.ruleForm,
                            }).then((res: any) => {
                                ElMessage.success(res.msg);
                                if (props.reload) props.reload();
                            });
                        } else {
                            ElMessage.success('修改成功');
                            au${entity}({
                                ...state.ruleForm,
                            }).then((res: any) => {
                                ElMessage.success(res.msg);
                                if (props.reload) props.reload();
                            });
                            state.isShowDialog = false;
                        }
                    }
                    closeDialog(); // 关闭弹窗
                });
            };

            const onHandleClose = () => {
                closeDialog();
                initForm();
            };

            const initForm = () => {
                    state.ruleForm = {
                        <@greet2 table/>
                    }
            };
            return {
                ...toRefs(state),
                openDialog,
                closeDialog,
                onCancel,
                onSubmitForm,
                onHandleClose,
                formRef,
            };
        },
    };
</script>
