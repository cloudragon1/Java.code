<template>
  <div class="app-container">
    <h2 style="margin-bottom:20px;">统计分析</h2>

    <!-- 顶部4个统计卡片 -->
    <el-row :gutter="20" style="margin-bottom:20px;">
      <el-col :span="6">
        <div class="stat-card">
          <div class="card-icon fuel"></div>
          <div class="card-text">
            <div class="card-title">燃料类型</div>
            <div class="card-num">13 类</div>
            <div class="card-desc">diesel oil 销量最高 614台</div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="stat-card">
          <div class="card-icon displace"></div>
          <div class="card-text">
            <div class="card-title">排量区间</div>
            <div class="card-num">4 段</div>
            <div class="card-desc">>2.0L 主流 789台</div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="stat-card">
          <div class="card-icon cartype"></div>
          <div class="card-text">
            <div class="card-title">车型分布</div>
            <div class="card-num">14 类</div>
            <div class="card-desc">Large ordinary bus 销量最高</div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="stat-card">
          <div class="card-icon gender"></div>
          <div class="card-text">
            <div class="card-num">男性 19%</div>
            <div class="card-desc">女性8% / 未知73%</div>
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 第一排图表：燃料饼图 + 用途饼图 -->
    <el-row :gutter="20" style="margin-bottom:20px;">
      <el-col :span="12">
        <div class="chart-box">
          <div class="chart-head">
            <span class="chart-name">燃料类型分布</span>
            <span class="chart-tag">饼图 · 共 13 类</span>
          </div>
          <div ref="fuelChart" style="width:100%;height:420px;"></div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="chart-box">
          <div class="chart-head">
            <span class="chart-name">车辆用途分布</span>
            <span class="chart-tag">饼图 · 共 13 类</span>
          </div>
          <div ref="useChart" style="width:100%;height:420px;"></div>
        </div>
      </el-col>
    </el-row>

    <!-- 第二排图表：车型环形图 + 性别仪表盘 -->
    <el-row :gutter="20" style="margin-bottom:20px;">
      <el-col :span="12">
        <div class="chart-box">
          <div class="chart-head">
            <span class="chart-name">车型分布</span>
            <span class="chart-tag">环形图 · 共 14 类</span>
          </div>
          <div ref="carTypeChart" style="width:100%;height:420px;"></div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="chart-box">
          <div class="chart-head">
            <span class="chart-name">购车性别比例</span>
            <span class="chart-tag">仪表盘 · 男性占比</span>
          </div>
          <div ref="genderChart" style="width:100%;height:420px;"></div>
        </div>
      </el-col>
    </el-row>

    <!-- 第三排通栏：排量区间柱状图 -->
    <el-row :gutter="20">
      <el-col :span="24">
        <div class="chart-box">
          <div class="chart-head">
            <span class="chart-name">排量区间销量分布</span>
            <span class="chart-tag">柱状图 · 共 4 段</span>
          </div>
          <div ref="displaceChart" style="width:100%;height:380px;"></div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: "StatAnalysis",
  data() {
    return {
      fuelChart: null,
      useChart: null,
      carTypeChart: null,
      genderChart: null,
      displaceChart: null,
      // 完全取自你的5张数据库表真实数据
      statData: {
        // car_stat_fuel燃料表
        fuelList: [
          {"name":"未知","value":20},
          {"name":"NG","value":12},
          {"name":"diesel oil","value":614},
          {"name":"gasoline","value":277},
          {"name":"gasolinenatural","value":6},
          {"name":"gasoline|CNG","value":2},
          {"name":"gasoline|natural","value":4},
          {"name":"gasoline和NG两混","value":1},
          {"name":"natural gas","value":97},
          {"name":"natural gas混合式","value":2},
          {"name":"混合动力","value":2},
          {"name":"甲醇","value":1},
          {"name":"电","value":1}
        ],
        // usage_dist用途表
        useList: [
          {"name":"CCKY","value":91},
          {"name":"JY","value":10},
          {"name":"MDSCHOOLBUS","value":1},
          {"name":"SCHOOLBUS","value":10},
          {"name":"School bus for c","value":9},
          {"name":"TRAKY","value":36},
          {"name":"XXXSCHOOLBUS","value":20},
          {"name":"highway passenger","value":283},
          {"name":"non-profitable","value":571},
          {"name":"工程救险","value":1},
          {"name":"教练","value":4},
          {"name":"消防","value":1},
          {"name":"租赁","value":2}
        ],
        // car_type_dist车型表
        carTypeList: [
          {"name":"未知","value":1},
          {"name":"BINORKK","value":114},
          {"name":"BI双层KK","value":1},
          {"name":"BI铰接KK","value":1},
          {"name":"Large ordinary bus","value":408},
          {"name":"Medium sized cc","value":147},
          {"name":"NOXNORKK","value":30},
          {"name":"NOXZYSCHOOLI","value":9},
          {"name":"NOX越野KK","value":1},
          {"name":"SMNOT","value":32},
          {"name":"Small passenger","value":260},
          {"name":"bigSchoolBus","value":31},
          {"name":"小型ZYKK","value":2},
          {"name":"微型NORKK","value":2}
        ],
        // gender_ratio性别表 总销量=767+82+190=1039，男性占比190/1039≈19%
        genderRate: 19,
        // disp_range_dist排量表
        displaceList: [
          {"name":"≤1.0L","value":89},
          {"name":"1.1-1.6L","value":130},
          {"name":"1.7-2.0L","value":31},
          {"name":">2.0L","value":789}
        ]
      }
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.renderAllChart()
    })
    // 窗口自适应重绘
    window.addEventListener('resize', () => {
      this.fuelChart?.resize()
      this.useChart?.resize()
      this.carTypeChart?.resize()
      this.genderChart?.resize()
      this.displaceChart?.resize()
    })
  },
  methods: {
    renderAllChart() {
      this.renderFuelPie()
      this.renderUsePie()
      this.renderCarRing()
      this.renderGenderGauge()
      this.renderDisplaceBar()
    },
    // 1.燃料类型饼图
    renderFuelPie() {
      this.fuelChart = echarts.init(this.$refs.fuelChart)
      const opt = {
        tooltip: { trigger: 'item', formatter: '{b}：{c}台' },
        legend: { left: 10, orient: 'vertical' },
        series: [{
          type: 'pie',
          radius: '60%',
          data: this.statData.fuelList,
          label: { show: true, formatter: '{b}\n{c}台' }
        }]
      }
      this.fuelChart.setOption(opt)
    },
    // 2.车辆用途饼图
    renderUsePie() {
      this.useChart = echarts.init(this.$refs.useChart)
      const opt = {
        tooltip: { trigger: 'item', formatter: '{b}：{c}台' },
        legend: { top: 0, left: 'center' },
        series: [{
          type: 'pie',
          radius: '60%',
          data: this.statData.useList,
          label: { show: true, formatter: '{b}\n{c}台' }
        }]
      }
      this.useChart.setOption(opt)
    },
    // 3.车型环形图
    renderCarRing() {
      this.carTypeChart = echarts.init(this.$refs.carTypeChart)
      const opt = {
        tooltip: { trigger: 'item', formatter: '{b}：{c}台' },
        legend: { left: 10, orient: 'vertical' },
        series: [{
          type: 'pie',
          radius: ['40%', '70%'],
          data: this.statData.carTypeList,
          label: { show: true, formatter: '{b}\n{c}台' }
        }]
      }
      this.carTypeChart.setOption(opt)
    },
    // 4.性别半圆仪表盘（男性占比19%）
    renderGenderGauge() {
      this.genderChart = echarts.init(this.$refs.genderChart)
      const opt = {
        series: [{
          type: 'gauge',
          startAngle: 180,
          endAngle: 0,
          min: 0, max: 100,
          splitNumber: 5,
          radius: '90%',
          pointer: { width: 4 },
          axisLine: {
            lineStyle: { width: 12, color: [[0.19, '#409EFF'], [1, '#E6F0FF']] }
          },
          axisTick: { distance: -12, splitNumber: 2, lineStyle: { width:2 } },
          splitLine: { distance: -12, length:6, lineStyle:{width:2} },
          axisLabel: { distance: 20, fontSize:12 },
          detail: { formatter: '{value}%', fontSize:36, offsetCenter: [0, '70%'] },
          data: [{ value: this.statData.genderRate, name: '男性占比' }]
        }]
      }
      this.genderChart.setOption(opt)
    },
    // 5.排量区间柱状图
    renderDisplaceBar() {
      this.displaceChart = echarts.init(this.$refs.displaceChart)
      const xData = this.statData.displaceList.map(item => item.name)
      const yData = this.statData.displaceList.map(item => item.value)
      const opt = {
        tooltip: { trigger: 'axis', formatter: '{b}：{c}台' },
        xAxis: { type: 'category', data: xData },
        yAxis: { type: 'value' },
        series: [{
          type: 'bar',
          data: yData,
          barWidth: '40%',
          itemStyle: { color: '#409EFF' },
          label: { show:true, position:'top', color:'red', fontSize:14, formatter:'{c}台' }
        }]
      }
      this.displaceChart.setOption(opt)
    }
  },
  beforeDestroy() {
    // 销毁图表防止页面卡顿内存溢出
    this.fuelChart?.dispose()
    this.useChart?.dispose()
    this.carTypeChart?.dispose()
    this.genderChart?.dispose()
    this.displaceChart?.dispose()
  }
}
</script>

<style scoped>
/* 顶部统计卡片样式 */
.stat-card {
  background: #fff;
  padding: 20px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  gap:16px;
}
.card-icon {
  width: 48px;
  height: 48px;
  border-radius: 6px;
}
.fuel { background:#E6643B; }
.displace { background:#409EFF; }
.cartype { background:#722ED1; }
.gender { background:#13C2C2; }
.card-title { font-size:14px; color:#666; }
.card-num { font-size:28px; font-weight:bold; margin:4px 0; }
.card-desc { font-size:13px; color:#999; }

/* 图表容器卡片 */
.chart-box {
  background:#fff;
  padding:20px;
  border-radius:6px;
}
.chart-head {
  display: flex;
  justify-content: space-between;
  margin-bottom:16px;
  align-items: center;
}
.chart-name { font-size:16px; font-weight:500; }
.chart-tag { color:#999; font-size:13px; }
</style>
