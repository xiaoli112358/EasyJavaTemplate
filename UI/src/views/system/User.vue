<template>
    <div class="app-container">
        <!--查询位置-->
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">
            <el-form-item label="关键词" prop="keyword">
                <el-input
                        v-model="queryParams.keyword"
                        placeholder="请输入关键词"
                        clearable
                        style="width: 240px"
                        @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <!--按钮位置-->
        <el-row :gutter="10" class="mb8" style="margin-bottom: 2px;">
            <el-col :span="1.5">
                <el-button
                        type="primary"
                        plain
                        icon="el-icon-plus"
                        size="mini"
                        @click="handleAdd"
                >新增
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                        type="danger"
                        plain
                        icon="el-icon-delete"
                        size="mini"
                        :disabled="multiple"
                        @click="handleDelete"
                >删除
                </el-button>
            </el-col>
        </el-row>

        <!--列表-->
        <el-table :height="tableMaxHeight" stripe border v-loading="loading" :data="tableDataList"
                  @selection-change="handleSelectionChange" ref="objectTable">
            <el-table-column type="selection" width="55" align="center"/>

            <el-table-column prop="userName" :show-overflow-tooltip="true" width="150" label="用户账号">
            </el-table-column>

            <el-table-column prop="email" :show-overflow-tooltip="true" width="150" label="用户邮箱">
            </el-table-column>

            <el-table-column prop="phonenumber" :show-overflow-tooltip="true" width="150" label="手机号码">
            </el-table-column>

            <el-table-column prop="avatar" :show-overflow-tooltip="true" width="150" label="头像地址">
            </el-table-column>

            <el-table-column prop="password" :show-overflow-tooltip="true" width="150" label="密码">
            </el-table-column>

            <el-table-column prop="remark" :show-overflow-tooltip="true" width="150" label="备注">
            </el-table-column>

            <el-table-column prop="createTime" :show-overflow-tooltip="true" width="150" label="创建时间">
            </el-table-column>

            <el-table-column prop="createUserId" :show-overflow-tooltip="true" width="150" label="创建人">
            </el-table-column>

            <el-table-column prop="updateTime" :show-overflow-tooltip="true" width="150" label="更新时间">
            </el-table-column>

            <el-table-column prop="updateUserId" :show-overflow-tooltip="true" width="150" label="更新人">
            </el-table-column>

            <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right"
                             min-width="130">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            type="text"
                            icon="el-icon-edit"
                            @click="handleUpdate(scope.row)"
                    >修改
                    </el-button>
                    <el-button
                            size="mini"
                            type="text"
                            icon="el-icon-delete"
                            @click="handleDelete(scope.row)"
                    >删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="queryParams.current"
                :page-sizes="[1, 5, 10, 50, 100, 300]"
                :page-size="queryParams.size"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total"
                style="float:left;margin-top: 20px;">
        </el-pagination>

        <!-- [新增/修改]弹框界面 -->
        <el-drawer
                :title="addForm.id ? '修改' : '新增'"
                :visible.sync="open"
                direction="rtl"
                size="50%"
        >
            <div style="width: 80%;margin-left: 50px;">
                <el-form ref="addFormRef" :model="addForm" :rules="rules" label-width="120px">

                    <el-form-item label="用户账号" prop="userName">
                        <el-input v-model="addForm.userName" placeholder="用户账号" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="用户邮箱" prop="email">
                        <el-input v-model="addForm.email" placeholder="用户邮箱" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="手机号码" prop="phonenumber">
                        <el-input v-model="addForm.phonenumber" placeholder="手机号码" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="头像地址" prop="avatar">
                        <el-input v-model="addForm.avatar" placeholder="头像地址" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="密码" prop="password">
                        <el-input v-model="addForm.password" placeholder="密码" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="addForm.remark" placeholder="备注" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="创建时间" prop="createTime">
                        <el-input v-model="addForm.createTime" placeholder="创建时间" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="创建人" prop="createUserId">
                        <el-input v-model="addForm.createUserId" placeholder="创建人" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="更新时间" prop="updateTime">
                        <el-input v-model="addForm.updateTime" placeholder="更新时间" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                    <el-form-item label="更新人" prop="updateUserId">
                        <el-input v-model="addForm.updateUserId" placeholder="更新人" auto-complete="off" maxlength="50"
                                  show-word-limit style="width: 100%;"></el-input>
                    </el-form-item>

                </el-form>
                <div slot="footer" class="dialog-footer"
                     style="text-align: center;margin-bottom: 50px;margin-top: 20px;">
                    <el-button type="primary" @click="submitForm">确 定</el-button>
                    <el-button @click="open = false">取 消</el-button>
                </div>
            </div>
        </el-drawer>
    </div>
</template>

<script>
    export default {
        name: "SysUser",
        data() {
            return {
                // 遮罩层
                loading: true,
                // 选中数组
                ids: [],
                // 非单个禁用
                single: true,
                // 非多个禁用
                multiple: true,
                // 总条数
                total: 0,
                // 参数表格数据
                tableDataList: [],
                // 是否显示弹出层
                open: false,
                // 日期范围
                dateRange: [],
                // 查询参数
                queryParams: {
                    current: 1,
                    size: 10,
                    keyword: undefined,
                },
                // 表单参数
                addForm: {},
                // 表单校验
                rules: {
                    id: [{required: true, message: '用户ID不能为空', trigger: 'blur'}],
                    userName: [{required: true, message: '用户账号不能为空', trigger: 'blur'}],
                    email: [{required: true, message: '用户邮箱不能为空', trigger: 'blur'}],
                    phonenumber: [{required: true, message: '手机号码不能为空', trigger: 'blur'}],
                    avatar: [{required: true, message: '头像地址不能为空', trigger: 'blur'}],
                    password: [{required: true, message: '密码不能为空', trigger: 'blur'}],
                    remark: [{required: true, message: '备注不能为空', trigger: 'blur'}],
                    createTime: [{required: true, message: '创建时间不能为空', trigger: 'blur'}],
                    createUserId: [{required: true, message: '创建人不能为空', trigger: 'blur'}],
                    updateTime: [{required: true, message: '更新时间不能为空', trigger: 'blur'}],
                    updateUserId: [{required: true, message: '更新人不能为空', trigger: 'blur'}],
                },
            };
        },

        methods: {

            /** 获取列表数据方法 */
            getList() {
                this.loading = true;
                this.$http.post("/sysUser/pagelist", this.queryParams).then(result => {
                    this.tableDataList = result.data.data.rows;
                    this.total = result.data.data.total;
                    this.loading = false;  //关闭加载圈
                });
            },

            /** 点击 搜索 按钮 */
            handleQuery() {
                this.queryParams.current = 1;
                this.getList();
            },

            /** 点击 重置 按钮 */
            resetQuery() {
                this.dateRange = [];
                if (this.$refs['queryForm']) {
                    this.$refs['queryForm'].resetFields();
                }
                this.handleQuery();
            },

            /** 选择第几页事件 */
            handleCurrentChange(current) {
                this.queryParams.current = current;
                this.getList();
            },

            /** 选择每页显示条数 */
            handleSizeChange(size) {
                this.queryParams.size = size
                this.getList();
            },

            /** 点击 新增 按钮 */
            handleAdd() {
                this.addForm = Object.assign({}, {});
                this.open = true;
            },

            /** 多选框选中数据事件 */
            handleSelectionChange(selection) {
                this.ids = selection.map(item => item.id);//将数组里面的ID取出来形成ids集合
                this.single = selection.length != 1;
                this.multiple = !selection.length;
            },

            /** 取消多选框选中的记录 */
            cancelSelectionChange() {
                this.$refs.objectTable.clearSelection();
            },

            /** 点击 修改 按钮 */
            handleUpdate(row) {
                this.addForm = Object.assign({}, row);
                this.open = true;
            },

            /** 提交按钮 */
            submitForm: function () {
                this.$refs["addFormRef"].validate(valid => {
                    if (valid) {
                        if (this.addForm.id != undefined) {
                            this.$http.post("/sysUser/update", this.addForm).then(result => {
                                this.open = false;
                                this.getList();
                            });
                        } else {
                            this.$http.post("/sysUser/save", this.addForm).then(result => {
                                this.open = false;
                                this.getList();
                            });
                        }
                    }
                });
            },

            /** 删除操作 */
            handleDelete(row) {
                if (row.id) {
                    this.cancelSelectionChange();//取消复选框
                    this.ids.push(row.id);
                }
                const tempIds = this.ids;
                let tishi = '';
                if (tempIds.length == 0) {
                    tishi = '您确定要删除这条数据吗';
                } else {
                    tishi = '您确定要删除这【' + tempIds.length + '】条数据吗？';
                }
                let param = {
                    "ids": tempIds,
                }
                this.$confirm(tishi, '请确认', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$http.post("/sysUser/batchDelete", param).then(result => {
                        if (result.data.success) {
                            this.$message({
                                type: 'success',
                                message: result.data.message
                            });
                        } else {
                            this.$message({
                                type: 'error',
                                message: result.data.message
                            });
                        }
                        this.getList();
                    });
                }).catch(() => {
                    console.log('已取消删除操作');
                });
            },
        },

        //计算表格高度
        computed: {
            tableMaxHeight() {
                return window.innerHeight - 280 + 'px'
            }
        },

        //钩子函数，进入页面就会加载的
        created() {
            this.getList();
        },
    };
</script>

<style scoped>
</style>