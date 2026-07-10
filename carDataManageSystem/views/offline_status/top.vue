<template>
  <div class="app-container">
    <!-- 顶部4统计卡片 -->
    <el-row :gutter="20" style="margin-bottom: 20px;">
      <!-- 总销量卡片 -->
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;align-items:center;gap:10px;">
            <div style="width:40px;height:40px;background:#e64340;border-radius:6px;display:flex;align-items:center;justify-content:center;color:#fff;">
              <i class="el-icon-shopping-cart-2" style="font-size:22px"></i>
            </div>
            <div>
              <div style="font-size:14px;color:#666">总销量</div>
              <div style="font-size:28px;font-weight:bold;margin:4px 0">{{ cardInfo.total.totalSales }}</div>
              <div style="color:#67c23a;font-size:13px">↑ 同比 +12.4%</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <!-- 城市TOP1卡片 -->
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;align-items:center;gap:10px;">
            <div style="width:40px;height:40px;background:#409EFF;border-radius:6px;display:flex;align-items:center;justify-content:center;color:#fff;">
              <i class="el-icon-location" style="font-size:22px"></i>
            </div>
            <div>
              <div style="font-size:14px;color:#666">城市TOP1</div>
              <div style="font-size:28px;font-weight:bold;margin:4px 0">{{ cardInfo.cityTop1.city }}</div>
              <div style="color:#67c23a;font-size:13px">销量{{ cardInfo.cityTop1.sales }}（占{{ cardInfo.cityTop1.rate }}）</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <!-- 品牌TOP1 修复换行溢出 -->
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;align-items:center;gap:10px;">
            <div style="width:40px;height:40px;background:#00B42A;border-radius:6px;display:flex;align-items:center;justify-content:center;color:#fff;">
              <i class="el-icon-data-line" style="font-size:22px"></i>
            </div>
            <!-- 新增max-width、自动换行，文字不会溢出卡片 -->
            <div style="max-width: calc(100% - 50px);">
              <div style="font-size:14px;color:#666">品牌TOP1</div>
              <div style="font-size:14px;font-weight:bold;margin:4px 0;word-wrap: break-word;white-space:normal;">
                {{ cardInfo.brandTop1.brand }}
              </div>
              <div style="color:#67c23a;font-size:13px">销量{{ cardInfo.brandTop1.sales }}（占{{ cardInfo.brandTop1.rate }}）</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <!-- 时间区间卡片 -->
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;align-items:center;gap:10px;">
            <div style="width:40px;height:40px;background:#9370DB;border-radius:6px;display:flex;align-items:center;justify-content:center;color:#fff;">
              <i class="el-icon-date" style="font-size:22px"></i>
            </div>
            <div>
              <div style="font-size:14px;color:#666">时间区间</div>
              <div style="font-size:28px;font-weight:bold;margin:4px 0">{{ cardInfo.time.yearRange }}</div>
              <div style="color:#67c23a;font-size:13px">{{ cardInfo.time.totalSales }} 累计销量</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <div style="display:flex;justify-content:flex-end;margin-bottom:12px;gap:10px;">
      <el-button icon="el-icon-refresh" @click="loadAllData">重新统计</el-button>
      <el-button type="success" icon="el-icon-download" @click="handleExport">导出Excel</el-button>
    </div>

    <el-tabs v-model="activeTab" lazy>
      <el-tab-pane label="城市销量TOP10" name="city">
        <el-table :data="cityTableList" optimize>
          <el-table-column label="排名" prop="ranke" width="70"/>
          <el-table-column label="城市" prop="city"/>
          <el-table-column label="省份" prop="province"/>
          <el-table-column label="销量" prop="sales"/>
          <el-table-column label="占TOP10总销量" prop="rate"/>
          <el-table-column label="备注" prop="remark"/>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="品牌销量TOP10" name="brand">
        <el-table :data="brandTableList" optimize>
          <el-table-column label="排名" prop="ranke" width="70"/>
          <el-table-column label="品牌" prop="company"/>
          <el-table-column label="销量" prop="sales"/>
          <el-table-column label="占TOP10总销量" prop="rate"/>
          <el-table-column label="备注" prop="remark"/>
        </el-table>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "SaleRank",
  data() {
    return {
      activeTab: "city",
      cardInfo: {
        total: { totalSales: 1039 },
        time: { yearRange: "2013 — 2013", totalSales: 1039 },
        cityTop1: { city: "Taiyuan", sales: 197, rate: "18.96%" },
        brandTop1: { brand: "zhengzhouyutongAutomobile Group Co., Ltd", sales: 123, rate: "11.84%" }
      },
      cityTableList: [
        { ranke: 1, city: "Taiyuan", province: "Shanxi Province", sales: 197, rate: "19.90%", remark: "销量冠军" },
        { ranke: 2, city: "yuncheng", province: "Shanxi Province", sales: 155, rate: "15.66%", remark: "TOP3" },
        { ranke: 3, city: "datong", province: "Shanxi Province", sales: 99, rate: "10.00%", remark: "TOP3" },
        { ranke: 4, city: "Lüliang", province: "Shanxi Province", sales: 82, rate: "8.28%", remark: "常规" },
        { ranke: 5, city: "changzhi", province: "Shanxi Province", sales: 82, rate: "8.28%", remark: "常规" },
        { ranke: 6, city: "xinzhou", province: "Shanxi Province", sales: 82, rate: "8.28%", remark: "常规" },
        { ranke: 7, city: "Linfen", province: "Shanxi Province", sales: 77, rate: "7.78%", remark: "常规" },
        { ranke: 8, city: "yangquan", province: "Shanxi Province", sales: 76, rate: "7.68%", remark: "常规" },
        { ranke: 9, city: "Jinzhong", province: "Shanxi Province", sales: 73, rate: "7.37%", remark: "常规" },
        { ranke: 10, city: "jincheng", province: "Shanxi Province", sales: 67, rate: "6.77%", remark: "常规" }
      ],
      brandTableList: [
        { ranke: 1, company: "zhengzhouyutongAutomobile Group Co., Ltd", sales: 123, rate: "11.84%", remark: "销量冠军" },
        { ranke: 2, company: "xiamenjinglongauto Group Co,. Ltd", sales: 62, rate: "5.97%", remark: "TOP3" },
        { ranke: 3, company: "jinlong  Motors Corporation, Ltd", sales: 53, rate: "5.10%", remark: "TOP3" },
        { ranke: 4, company: "SAIC GM Wuling Automobile Co., Ltd", sales: 36, rate: "3.46%", remark: "常规" },
        { ranke: 5, company: "Jiangling Motors Corporation, Ltd", sales: 36, rate: "3.46%", remark: "常规" },
        { ranke: 6, company: "xiamenjinglongTCCLD", sales: 34, rate: "3.27%", remark: "常规" },
        { ranke: 7, company: "Zhongtong bus Holding Co., Ltd", sales: 33, rate: "3.18%", remark: "常规" },
        { ranke: 8, company: "Dongfeng Xiaokang Automobile Co., Ltd", sales: 30, rate: "2.89%", remark: "常规" },
        { ranke: 9, company: "HN-SLAutomobile Group Co., Ltd", sales: 28, rate: "2.70%", remark: "常规" },
        { ranke: 10, company: "shengyang hc Automobile Group Co., Ltd", sales: 25, rate: "2.41%", remark: "常规" }
      ]
    }
  },
  methods: {
    loadAllData() {
      this.$alert("当前为离线静态页面，数据已预加载，无需重新计算");
    },
    handleExport() {
      this.$alert("离线静态页面，导出功能需后端配合");
    }
  }
}
</script>
