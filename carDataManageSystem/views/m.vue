<template>
  <div class="p5-page-wrap">
    <!-- P5顶部斜切标题栏 完全匹配截图 -->
    <div class="p5-header">
      <h1 class="page-title">售车录入</h1>
      <span class="header-en">SALES CAR INPUT</span>
    </div>

    <!-- 表单外层居中容器 -->
    <div class="center-wrap">
      <div class="p5-form-card">
        <el-form :model="form" label-width="100px" class="p5-form">
          <!-- 基础车辆信息 -->
          <div class="p5-form-group">
            <div class="p5-group-tag">基础车辆信息</div>
            <el-row :gutter="30">
              <el-col :span="12">
                <el-form-item label="车架号" prop="vin">
                  <el-input v-model="form.vin" placeholder="请输入车架号" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="车系" prop="carSeries">
                  <el-input v-model="form.carSeries" placeholder="请输入车系" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="年份" prop="year">
                  <el-input v-model="form.year" placeholder="请输入年份" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="月份" prop="month">
                  <el-input v-model="form.month" placeholder="请输入月份" />
                </el-form-item>
              </el-col>
            </el-row>
          </div>

          <!-- 销售地域 -->
          <div class="p5-form-group">
            <div class="p5-group-tag">销售地域</div>
            <el-row :gutter="30">
              <el-col :span="8">
                <el-form-item label="省份" prop="province">
                  <el-input v-model="form.province" placeholder="请输入省份" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="城市" prop="city">
                  <el-input v-model="form.city" placeholder="请输入城市" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="区县" prop="county">
                  <el-input v-model="form.county" placeholder="请输入区县" />
                </el-form-item>
              </el-col>
            </el-row>
          </div>

          <!-- 主体与用途 -->
          <div class="p5-form-group">
            <div class="p5-group-tag">主体与用途</div>
            <el-row :gutter="30">
              <el-col :span="12">
                <el-form-item label="公司" prop="company">
                  <el-input v-model="form.company" placeholder="请输入公司" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所属企业" prop="ownerCompany">
                  <el-input v-model="form.ownerCompany" placeholder="请输入所属企业" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商用或个人" prop="useKind">
                  <el-select v-model="form.useKind" placeholder="请选择">
                    <el-option label="个人" value="personal"></el-option>
                    <el-option label="商用" value="Large ordinary bus"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="用途" prop="useFor">
                  <el-input v-model="form.useFor" placeholder="请输入用途" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="销量" prop="sales">
                  <el-input v-model="form.sales" placeholder="请输入销量" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="车属分类" prop="carClass">
                  <el-input v-model="form.carClass" placeholder="请输入车属分类" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="性别" prop="gender">
                  <el-input v-model="form.gender" placeholder="请输入性别" />
                </el-form-item>
              </el-col>
            </el-row>
          </div>

          <!-- 动力参数 -->
          <div class="p5-form-group">
            <div class="p5-group-tag">动力参数</div>
            <el-row :gutter="30">
              <el-col :span="12">
                <el-form-item label="发动机型号" prop="engine">
                  <el-input v-model="form.engine" placeholder="请输入发动机型号" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="排量(cc)" prop="displacement">
                  <el-input v-model="form.displacement" placeholder="请输入排量(cc)" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="发动机参数1" prop="engineParam1">
                  <el-input v-model="form.engineParam1" placeholder="参数1" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="发动机参数3" prop="engineParam3">
                  <el-input v-model="form.engineParam3" placeholder="参数3" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="轮胎规格" prop="tireSpec">
                  <el-input v-model="form.tireSpec" placeholder="轮胎规格" />
                </el-form-item>
              </el-col>
            </el-row>
          </div>
        </el-form>
        <!-- 右下角斜切确定按钮 -->
        <div class="btn-box">
          <el-button class="submit-btn" @click="add">确 定</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import request from '@/utils/request'
export default {
  name: "m",
  data() {
    return {
      rr: "",
      form: {
        id: null,
        province: "shanxi",
        city: "Taiyuan",
        county: "CITYZONE",
        year: 2026,
        month: 6,
        company: "东风小康汽车有限公司",
        sales: 1,
        engineParam1: "103",
        engineParam3: "未知",
        tireSpec: "未知",
        ownerCompany: "未知",
        carClass: "未知",
        vin: null,
        carSeries: null,
        carType: null,
        useKind: null,
        useFor: null,
        engine: null,
        displacement: 2,
        fuelType: null,
        gender: null
      },
    }
  },
  mounted() {
    this.getList()
  },
  methods: {
    getList() {
      const query = { pageNum: 1, pageSize: 10 }
      request({
        url: 'http://localhost:8080/mobile/list',
        method: 'get',
        params: query
      }).then(response => {
        console.log(response)
        this.rr = response
      })
    },
    add() {
      console.log(this.form)
      request({
        url: 'http://localhost:8080/mobile/add',
        method: 'post',
        data: this.form
      }).then(response => {
        console.log(response)
        if (response == "1") {
          this.$modal.msgSuccess("新增成功")
        } else {
          this.$modal.msgError("新增失败")
        }
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
$p5-black: #000000;
$p5-dark-bg: #1a1a1a;
$p5-red: #c41020;
$p5-text-gray: #888888;
$p5-white: #ffffff;

.p5-page-wrap {
  background: $p5-black;
  min-height: 100vh;
  padding: 40px 0;
}

// 顶部红色斜切标题栏
.p5-header {
  width: 90%;
  margin: 0 auto 40px;
  height: 80px;
  background: $p5-red;
  position: relative;
  // 左右不规则斜角
  clip-path: polygon(0 0, 97% 0, 100% 50%, 96% 100%, 50% 100%, 0 100%);
  display: flex;
  align-items: center;
  padding-left: 40px;
  .page-title {
    color: $p5-white;
    font-size: 38px;
    font-weight: 900;
    letter-spacing: 3px;
    text-shadow: 2px 2px 0 #000;
    margin: 0;
  }
  .header-en {
    position: absolute;
    right: 45px;
    bottom: 12px;
    color: #000;
    font-size: 15px;
    font-weight: bold;
    letter-spacing: 1px;
  }
}

// 核心居中容器 解决表单不居中问题
.center-wrap {
  width: 90%;
  margin: 0 auto;
  display: flex;
  justify-content: center;
}

// 表单卡片
.p5-form-card {
  width: 100%;
  max-width: 1400px;
  background: $p5-dark-bg;
  border: 2px solid $p5-red;
  padding: 45px 35px;
  // 右下角轻微斜切
  clip-path: polygon(0 0, 100% 0, 100% 94%, 97% 100%, 0 100%);
  box-sizing: border-box;

  .p5-form-group {
    margin-bottom: 40px;
    position: relative;
    padding-top: 18px;
    border-bottom: 1px dashed #333;
    // 红色分组斜标签
    .p5-group-tag {
      position: absolute;
      top: -16px;
      left: 0;
      background: $p5-red;
      color: #fff;
      padding: 5px 20px;
      font-size: 15px;
      font-weight: bold;
      clip-path: polygon(0 0, 90% 0, 100% 100%, 0 100%);
    }
  }

  // 表单全局样式
  .el-form-item {
    margin-bottom: 24px;
    .el-form-item__label {
      color: $p5-text-gray;
      font-size: 14px;
    }
  }

  // 输入框 纯白底色匹配截图
  .el-input__inner {
    background: #fff;
    border: none;
    color: #000;
    height: 40px;
    border-radius: 0;
    &::placeholder {
      color: #aaa;
    }
  }

  // 下拉选择器
  .el-select .el-input__inner {
    background: #fff;
  }
  .el-select-dropdown {
    background: #111;
    border: 1px solid $p5-red;
    .el-select-dropdown__item {
      color: #ccc;
      &:hover {
        background: rgba(196, 16, 32, 0.2);
      }
      &.selected {
        background: $p5-red;
        color: #fff;
      }
    }
  }

  // 右下角按钮区域
  .btn-box {
    margin-top: 50px;
    text-align: right;
    .submit-btn {
      background: $p5-red;
      border: none;
      color: #fff;
      font-size: 16px;
      font-weight: bold;
      padding: 12px 50px;
      border-radius: 0;
      clip-path: polygon(6% 0, 100% 0, 94% 100%, 0 100%);
      &:hover {
        background: #e01424;
      }
    }
  }
}
</style>
