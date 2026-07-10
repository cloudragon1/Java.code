<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车架号" prop="vin">
        <el-input
          v-model="queryParams.vin"
          placeholder="请输入车架号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="城市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="月份" prop="month">
        <el-input
          v-model="queryParams.month"
          placeholder="请输入月份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车系" prop="carSeries">
        <el-input
          v-model="queryParams.carSeries"
          placeholder="请输入车系"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['base:base:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['base:base:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['base:base:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['base:base:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="baseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="id" align="center" prop="id"  />-->
      <el-table-column label="车架号" align="center" prop="vin" />
<!--      <el-table-column label="省份" align="center" prop="province" />-->
      <el-table-column label="城市" align="center" prop="city" />
      <el-table-column label="区县" align="center" prop="county" />
<!--      <el-table-column label="年份" align="center" prop="year" />-->
      <el-table-column label="月份" align="center" prop="month" />
      <el-table-column label="公司" align="center" prop="company" />
      <el-table-column label="车系" align="center" prop="carSeries" />
<!--      <el-table-column label="车型" align="center" prop="carType" />-->
<!--      <el-table-column label="商用或个人" align="center" prop="useKind" />-->
<!--      <el-table-column label="用途" align="center" prop="useFor" />-->
<!--      <el-table-column label="销量" align="center" prop="sales" />-->
<!--      <el-table-column label="发动机型号" align="center" prop="engine" />-->
<!--      <el-table-column label="排量(cc)" align="center" prop="displacement" />-->
<!--      <el-table-column label="发动机参数1" align="center" prop="engineParam1" />-->
<!--      <el-table-column label="燃油类型" align="center" prop="fuelType" />-->
<!--      <el-table-column label="发动机参数3" align="center" prop="engineParam3" />-->
<!--      <el-table-column label="轮胎规格" align="center" prop="tireSpec" />-->
<!--      <el-table-column label="所属企业" align="center" prop="ownerCompany" />-->
<!--      <el-table-column label="车属分类" align="center" prop="carClass" />-->
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['base:base:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['base:base:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改乘用车销售清洗后数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="车架号" prop="vin">
              <el-input v-model="form.vin" placeholder="请输入车架号" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="省份" prop="province">
              <el-input v-model="form.province" placeholder="请输入省份" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="城市" prop="city">
              <el-input v-model="form.city" placeholder="请输入城市" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="区县" prop="county">
              <el-input v-model="form.county" placeholder="请输入区县" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="年份" prop="year">
              <el-input v-model="form.year" placeholder="请输入年份" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="月份" prop="month">
              <el-input v-model="form.month" placeholder="请输入月份" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="公司" prop="company">
              <el-input v-model="form.company" placeholder="请输入公司" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="车系" prop="carSeries">
              <el-input v-model="form.carSeries" placeholder="请输入车系" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="商用或个人" prop="useKind">
              <el-input v-model="form.useKind" placeholder="请输入商用或个人" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="用途" prop="useFor">
              <el-input v-model="form.useFor" placeholder="请输入用途" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="销量" prop="sales">
              <el-input v-model="form.sales" placeholder="请输入销量" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="发动机型号" prop="engine">
              <el-input v-model="form.engine" placeholder="请输入发动机型号" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="排量(cc)" prop="displacement">
              <el-input v-model="form.displacement" placeholder="请输入排量(cc)" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="发动机参数1" prop="engineParam1">
              <el-input v-model="form.engineParam1" placeholder="请输入发动机参数1" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="发动机参数3" prop="engineParam3">
              <el-input v-model="form.engineParam3" placeholder="请输入发动机参数3" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="轮胎规格" prop="tireSpec">
              <el-input v-model="form.tireSpec" placeholder="请输入轮胎规格" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="所属企业" prop="ownerCompany">
              <el-input v-model="form.ownerCompany" placeholder="请输入所属企业" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="车属分类" prop="carClass">
              <el-input v-model="form.carClass" placeholder="请输入车属分类" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="性别" prop="gender">
              <el-input v-model="form.gender" placeholder="请输入性别" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBase, getBase, delBase, addBase, updateBase } from "@/api/base/base"

export default {
  name: "Base",
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
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 乘用车销售清洗后数据表格数据
      baseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        vin: null,
        province: null,
        city: null,
        county: null,
        year: null,
        month: null,
        company: null,
        carSeries: null,
        carType: null,
        useKind: null,
        useFor: null,
        sales: null,
        engine: null,
        displacement: null,
        engineParam1: null,
        fuelType: null,
        engineParam3: null,
        tireSpec: null,
        ownerCompany: null,
        carClass: null,
        gender: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        vin: [
          { required: true, message: "车架号不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询乘用车销售清洗后数据列表 */
    getList() {
      this.loading = true
      listBase(this.queryParams).then(response => {
        this.baseList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        vin: null,
        province: null,
        city: null,
        county: null,
        year: null,
        month: null,
        company: null,
        carSeries: null,
        carType: null,
        useKind: null,
        useFor: null,
        sales: null,
        engine: null,
        displacement: null,
        engineParam1: null,
        fuelType: null,
        engineParam3: null,
        tireSpec: null,
        ownerCompany: null,
        carClass: null,
        gender: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加乘用车销售清洗后数据"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getBase(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改乘用车销售清洗后数据"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBase(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addBase(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除乘用车销售清洗后数据编号为"' + ids + '"的数据项？').then(function() {
        return delBase(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('base/base/export', {
        ...this.queryParams
      }, `base_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
