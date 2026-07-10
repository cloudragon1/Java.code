<template>
  <div id="bg">
    <div><br>
      <el-row>
        <el-col :span="24">
          <div class="p5-title-outer">
            <div class="p5-title-bar"><br>
              <span class="p5-title-text">乘用车实时销量大数据平台</span>
            </div>
          </div>
        </el-col>
      </el-row><br>
      <el-row>
        <el-col :span="8">.</el-col>
        <el-col :span="8">
          <div class="p5-card-outer">
            <div class="p5-border-out"></div>
            <div class="p5-border-mid"></div>
            <div class="p5-card">
              <div class="p5-content">
                累计销售：
                <span class="p5-tag">{{ count }}</span>
                <span class="p5-unit">辆</span>
              </div>
              <div class="fragment f1"></div>
              <div class="fragment f2"></div>
              <div class="fragment f3"></div>
              <div class="fragment f4"></div>
              <div class="fragment f5"></div>
              <div class="fragment f6"></div>
            </div>
          </div>
        </el-col>
        <el-col :span="8"></el-col>
      </el-row><br>
      <el-row style="margin-top:20px;display:flex;gap:20px;justify-content:center;">

        <el-col :span="12">
          <div class="p5-card-outer">
            <div class="p5-card p5-pie-wrap">
              <div class="p5-pie-title">车辆燃料类型销量统计</div>
              <div id="fuelBarChart" style="width:100%;height:420px;"></div>
              <div class="fragment f1"></div>
              <div class="fragment f2"></div>
              <div class="fragment f3"></div>
              <div class="fragment f4"></div>
              <div class="fragment f5"></div>
              <div class="fragment f6"></div>
            </div>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="p5-card-outer">
            <div class="p5-card p5-pie-wrap">
              <div class="p5-pie-title">山西省各地级市销量排行</div>
              <div id="cityRankChart" style="width:100%;height:420px;"></div>
              <div class="fragment f1"></div>
              <div class="fragment f2"></div>
              <div class="fragment f3"></div>
              <div class="fragment f4"></div>
              <div class="fragment f5"></div>
              <div class="fragment f6"></div>
            </div>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="p5-card-outer">
            <div class="p5-card p5-pie-wrap">
              <div class="p5-pie-title">购车性别占比</div>
              <div id="pieChart" style="width:100%;height:400px;"></div>
              <div class="fragment f1"></div>
              <div class="fragment f2"></div>
              <div class="fragment f3"></div>
              <div class="fragment f4"></div>
              <div class="fragment f5"></div>
              <div class="fragment f6"></div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import * as echarts from 'echarts';

export default {
  name: "big",
  data() {
    return {
      count: 0,

      /*性别数据*/
      male: 0,
      female: 0,
      unknown: 0,

      /*燃料数据*/
      gasoline: 0,
      diesel: 0,
      gas: 0,
      hybrid: 0,

      /*山西11地级市销量*/
      taiyuan: 0,
      datong: 0,
      shuozhou: 0,
      xinzhou: 0,
      yangquan: 0,
      lvliang: 0,
      jinzhong: 0,
      changzhi: 0,
      jincheng: 0,
      linfen: 0,
      yuncheng: 0,


      timer: null, // 用来存储定时器ID
      pieChart: null,
      fuelBarChart: null,
      cityRankChart: null
    };
  },
  mounted() {
    this.pieChart = echarts.init(document.getElementById('pieChart'));
    this.fuelBarChart = echarts.init(document.getElementById('fuelBarChart'));
    this.cityRankChart = echarts.init(document.getElementById('cityRankChart'));
    this.renderPie();
    this.renderFuelBar();
    this.renderCityRank();

    this.fetchData();
    // 组件挂载后自动启动定时器（根据业务需求选择）
    this.startTimer()
  },
  beforeDestroy() {
    // 🔴 核心：组件销毁前必须清除定时器
    this.stopTimer()
    if (this.pieChart) this.pieChart.dispose();
    if (this.fuelBarChart) this.fuelBarChart.dispose();
    if (this.cityRankChart) this.cityRankChart.dispose();
  },
  methods: {
    async fetchData() {
      try {
        // 1、累计销量
        let countRes = await request({ url: "/big/get_count", method: "get" });
        //【改动3】取返回体data字段，转数字兜底
        this.count = Number(countRes.data || 0);

        // 2、性别数据
        let maleRes = await request({ url: "/big/get_male", method: "get" });
        let femaleRes = await request({ url: "/big/get_female", method: "get" });
        let unknownRes = await request({ url: "/big/get_unknown", method: "get" });
        this.male = Number(maleRes.data || 0);
        this.female = Number(femaleRes.data || 0);
        this.unknown = Number(unknownRes.data || 0);
        this.renderPie();

        // 3、燃料柱状图数据
        let gasoRes = await request({ url: "/big/get_gasoline", method: "get" });
        let dieRes = await request({ url: "/big/get_diesel", method: "get" });
        let gasRes = await request({ url: "/big/get_gas", method: "get" });
        let hyRes = await request({ url: "/big/get_hybrid", method: "get" });
        this.gasoline = Number(gasoRes.data || 0);
        this.diesel = Number(dieRes.data || 0);
        this.gas = Number(gasRes.data || 0);
        this.hybrid = Number(hyRes.data || 0);
        this.renderFuelBar();

        // 4、山西11个城市销量数据
        let taiyuanRes = await request({ url: "/big/get_taiyuan", method: "get" });
        let datongRes = await request({ url: "/big/get_datong", method: "get" });
        let shuozhouRes = await request({ url: "/big/get_shuozhou", method: "get" });
        let xinzhouRes = await request({ url: "/big/get_xinzhou", method: "get" });
        let yangquanRes = await request({ url: "/big/get_yangquan", method: "get" });
        let lvliangRes = await request({ url: "/big/get_lvliang", method: "get" });
        let jinzhongRes = await request({ url: "/big/get_jinzhong", method: "get" });
        let changzhiRes = await request({ url: "/big/get_changzhi", method: "get" });
        let jinchengRes = await request({ url: "/big/get_jincheng", method: "get" });
        let linfenRes = await request({ url: "/big/get_linfen", method: "get" });
        let yunchengRes = await request({ url: "/big/get_yuncheng", method: "get" });

        this.taiyuan = Number(taiyuanRes.data || 0);
        this.datong = Number(datongRes.data || 0);
        this.shuozhou = Number(shuozhouRes.data || 0);
        this.xinzhou = Number(xinzhouRes.data || 0);
        this.yangquan = Number(yangquanRes.data || 0);
        this.lvliang = Number(lvliangRes.data || 0);
        this.jinzhong = Number(jinzhongRes.data || 0);
        this.changzhi = Number(changzhiRes.data || 0);
        this.jincheng = Number(jinchengRes.data || 0);
        this.linfen = Number(linfenRes.data || 0);
        this.yuncheng = Number(yunchengRes.data || 0);
        this.renderCityRank();

      } catch (err) {
        // 捕获报错，定时器不会中断
        console.error("数据请求异常", err);
      }
    },
    startTimer() {
      if (this.timer) return;
      //【改动4】删除无用分页参数query，定时器直接调用封装好的fetchData
      this.timer = setInterval(() => {
        this.fetchData();
      },10000)
    },
    stopTimer() {
      clearInterval(this.timer);
      this.timer = null; // 清空引用
    },
    renderPie() {
      // 把三个数字组装成饼图数据
      const chartData = [
        { name: '男性', value: Number(this.male), itemStyle: { color: '#666666' }},
        { name: '女性', value: Number(this.female), itemStyle: { color: '#e62429' }},
        { name: '未知', value: Number(this.unknown), itemStyle: { color: '#222222' }},
      ]
      const option = {
        tooltip: {
          trigger: 'item',
          formatter: '{b}：{c}辆，占比{d}%'
        },
        legend: {
          bottom: 10,
          textStyle: { color: '#fff' }
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '70%'], // 环形饼图，去掉[]就是普通实心饼图
            data: chartData,
            itemStyle: {
              borderRadius: 6
            }
          }
        ]
      }
      this.pieChart.setOption(option)
    },
    renderFuelBar() {
      const fuelOption = {
        tooltip: {
          trigger: 'axis',
          formatter: '{b}：{c}辆'
        },
        legend: {
          textStyle: { color: '#fff' }
        },
        xAxis: {
          type: 'category',
          data: ['汽油', '柴油', '天然气', '油气混动'],
          axisLine: { lineStyle: { color: '#fff' } },
          axisLabel: { color: '#fff' }
        },
        yAxis: {
          type: 'value',
          axisLine: { lineStyle: { color: '#fff' } },
          axisLabel: { color: '#fff' },
          splitLine: { lineStyle: { color: '#444' } }
        },
        series: [
          {
            name: '销量',
            type: 'bar',
            data: [
              Number(this.gasoline),
              Number(this.diesel),
              Number(this.gas),
              Number(this.hybrid)
            ],
            itemStyle: {
              color: '#e62429',
              borderRadius: 4
            },
            barWidth: '40%'
          }
        ]
      }
      this.fuelBarChart.setOption(fuelOption)
    },
    renderCityRank() {
      // 组装城市数组：城市名称、销量
      const cityList = [
        { name: "太原", value: Number(this.taiyuan) },
        { name: "大同", value: Number(this.datong) },
        { name: "朔州", value: Number(this.shuozhou) },
        { name: "忻州", value: Number(this.xinzhou) },
        { name: "阳泉", value: Number(this.yangquan) },
        { name: "吕梁", value: Number(this.lvliang) },
        { name: "晋中", value: Number(this.jinzhong) },
        { name: "长治", value: Number(this.changzhi) },
        { name: "晋城", value: Number(this.jincheng) },
        { name: "临汾", value: Number(this.linfen) },
        { name: "运城", value: Number(this.yuncheng) }
      ];
      // 降序排序，取前10名
      cityList.sort((a, b) => b.value - a.value);
      const top10 = cityList.slice(0, 10);
      // 分离名称、销量
      const cityNames = top10.map(item => item.name);
      const citySales = top10.map(item => item.value);

      const option = {
        tooltip: {
          trigger: 'axis',
          formatter: '{b}：{c}辆'
        },
        grid: { left: '3%', right: '4%', bottom: '3%', containLabel: true },
        xAxis: {
          type: 'value',
          axisLine: { lineStyle: { color: '#fff' } },
          axisLabel: { color: '#fff' },
          splitLine: { lineStyle: { color: '#444' } }
        },
        yAxis: {
          type: 'category',
          data: cityNames,
          axisLine: { lineStyle: { color: '#fff' } },
          axisLabel: { color: '#fff' }
        },
        series: [
          {
            name: "销量",
            type: "bar",
            data: citySales,
            itemStyle: { color: '#e62429', borderRadius: [0,4,4,0] },
            barWidth: '40%'
          }
        ]
      };
      this.cityRankChart.setOption(option);
    },
  }
};
</script>

<style scoped>
#bg{
  width: 100%;
  height: 100%;
  background-color: #999999;
  background-image: url(./bg.jpg);
  background-size: cover;     /* 铺满盒子 */
  background-position: center; /* 居中 */
  background-repeat: no-repeat;/* 不重复 */
  background-blend-mode: multiply;
  color: white;
}
/* P5 字体 */
@font-face {
  font-family: 'P5Font';
  src: url('https://fonts.gstatic.com/s/anton/v23/1Ptgg87LROyAm3Kz-Cn-8KS0yIsw.woff2') format('woff2');
  font-weight: normal;
  font-style: normal;
}

.p5-card-outer {
  position: relative;
  transform: skewX(-4deg);
}

/* 主卡片 大锯齿撕裂边框 + 噪点纹理 */
.p5-card {
  position: relative;
  padding: 24px 28px;
  background: #111;
  color: #fff;
  font-family: 'P5Font', "Microsoft Yahei", sans-serif;
  font-size: 18px;
  letter-spacing: 1px;
  /* 不规则撕裂边框 */
  clip-path: polygon(
    0 24px, 24px 0, calc(100% - 12px) 0, 100% 12px,
    100% calc(100% - 24px), calc(100% - 24px) 100%,
    12px 100%, 0 calc(100% - 12px)
  );
  border: 5px solid #e62429;
  box-shadow: 0 0 15px rgba(230, 36, 41, 0.4);
  background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 200 200' xmlns='http://www.w3.org/2000/svg'%3E%3Cfilter id='noise'%3E%3CfeTurbulence type='fractalNoise' baseFrequency='0.65' numOctaves='3' stitchTiles='stitch'/%3E%3C/filter%3E%3Crect width='100%' height='100%' filter='url(%23noise)' opacity='0.08'/%3E%3C/svg%3E");
}

.p5-content {
  line-height: 1.4;
  position: relative;
  z-index: 3;
}

/* 数值标签 锯齿样式 */
.p5-tag {
  display: inline-block;
  margin: 0 8px;
  padding: 6px 16px;
  background: #e62429;
  color: #fff;
  font-weight: bold;
  font-size: 24px;
  clip-path: polygon(12px 0, 100% 0, 100% 100%, 0 100%, 0 12px);
}

.p5-unit {
  color: #ccc;
  font-size: 17px;
}

/* 外层红色不规则边框 */
.p5-title-outer {
  width: 100%;
  height: 110px;
  background: #e62429;
  /* 比内框大一圈的同比例锯齿路径，实现外红内黑双边框 */
  clip-path: polygon(
    0% 0%,
    5% 10%,
    15% 0%,
    25% 8%,
    35% 0%,
    45% 10%,
    55% 0%,
    65% 8%,
    75% 0%,
    85% 10%,
    95% 0%,
    100% 15%,
    98% 50%,
    100% 85%,
    95% 100%,
    85% 92%,
    75% 100%,
    65% 92%,
    55% 100%,
    45% 92%,
    35% 100%,
    25% 92%,
    15% 100%,
    5% 92%,
    0% 100%,
    2% 50%
  );
  padding: 2px; /* 控制红色边框的粗细 */
}

/* 内层黑色框（完全沿用你之前的样式，未做任何修改） */
.p5-title-bar {
  width: 100%;
  height: 100px;
  padding: 12px 24px;
  background: #111;
  border: 2px solid #e62429;
  clip-path: polygon(
    1% 0%,
    5% 20%,
    15% 0%,
    25% 18%,
    35% 0%,
    45% 20%,
    55% 0%,
    65% 18%,
    75% 0%,
    85% 20%,
    95% 10%,
    99% 25%,
    96% 50%,
    99% 85%,
    95% 100%,
    85% 82%,
    75% 100%,
    65% 82%,
    55% 100%,
    45% 82%,
    35% 100%,
    25% 82%,
    15% 100%,
    5% 82%,
    1% 100%,
    3% 40%
  );
  box-shadow: 0 0 10px rgba(230, 36, 41, 0.7);
  overflow: hidden;
}

.p5-title-text {
  display: block;
  text-align: center;
  font-size: 24px;
  font-weight: 900;
  color: #fff;
  letter-spacing: 2px;
  text-shadow: 1px 1px 0 #e62429, -1px -1px 0 #e62429;
}



.p5-pie-wrap {
  padding: 20px 16px;
}
.p5-pie-title {
  text-align: center;
  font-size: 20px;
  margin-bottom: 12px;
  text-shadow: 1px 1px 0 #e62429;
}
</style>
