<template>
  <div class="app-container home">
    <!-- 头部标题区 -->
    <div class="header-box">
      <h1 class="main-title">车辆大数据平台</h1>
      <p class="sub-desc">DATA MANAGEMENT & ANALYSIS SYSTEM</p>
    </div>

    <el-divider class="line-divider" />

    <!-- 第一行 两大板块 -->
    <el-row :gutter="24" class="row-wrap">
      <el-col :span="12">
        <div class="nice-card">
          <div class="card-head">
            <span class="card-label">平台综述</span>
          </div>
          <div class="card-text">
            本系统基于分布式架构搭建，专注于车辆行业全维度数据统筹管理。依托稳定的底层服务，实现数据归集、存储、查询与汇总一体化运转，架构轻量化且扩展性强，可长期支撑日常业务流转。整体设计遵循简约高效原则，在保证运行稳定的同时，兼顾视觉质感与操作体验，适配多种办公场景使用。
            <br><br>
            系统对数据进行标准化分类管理，流程清晰、逻辑严谨，从源头保障信息完整有序，为日常统计、业务复盘与决策参考提供可靠的数据支撑。
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="nice-card">
          <div class="card-head">
            <span class="card-label">操作指引</span>
          </div>
          <div class="card-text">
            系统所有业务功能均集成于左侧导航菜单栏，点击对应选项即可快速进入操作页面。界面分区明确，交互逻辑统一，上手简单，无需复杂学习即可熟练使用。
            <br><br>
            日常使用请保持规范操作，非运维人员请勿改动系统基础配置。若出现页面卡顿、加载异常等临时问题，刷新页面即可恢复正常。建议定期梳理数据内容，维护系统整洁，让整体办公流程更加顺畅高效。
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 第二行 三列小卡片 -->
    <el-row :gutter="24" class="row-wrap">
      <el-col :span="8">
        <div class="mini-card">
          <div class="mini-title card-label">稳定存储</div>
          <div class="mini-text">分布式数据服务，读写高效、安全持久，分层管理海量业务数据。</div>
        </div>
      </el-col>
      <el-col :span="8">
        <div class="mini-card">
          <div class="mini-title card-label">权限管控</div>
          <div class="mini-text">多级角色权限体系，精细化访问限制，全方位守护数据安全。</div>
        </div>
      </el-col>
      <el-col :span="8">
        <div class="mini-card">
          <div class="mini-title card-label">持续运维</div>
          <div class="mini-text">后台服务全天候在线，定期迭代优化，保障系统稳定运行。</div>
        </div>
      </el-col>
    </el-row>

    <!-- 底部通栏板块 -->
    <el-row :gutter="24" class="row-wrap">
      <el-col :span="24">
        <div class="full-card">
          <div class="card-head">
            <span class="card-label">使用寄语</span>
          </div>
          <div class="card-text">
            首页为系统欢迎展示区域，仅作信息阅览使用。正式业务办理、数据录入、报表查看等操作，请前往左侧对应功能模块完成。本平台致力于简化工作流程、提升办公效率，以简洁界面搭配强大功能，服务于日常各项业务工作。秉持稳定、高效、简洁的设计理念，不断打磨细节，营造舒适专业的使用环境。
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>
.home {
  padding: 40px 35px;
  background-color: #f8f9fa;
  min-height: calc(100vh - 84px);
}

/* 头部标题 */
.header-box {
  text-align: center;
  margin-bottom: 50px;
}
.main-title {
  font-size: 32px;
  font-weight: 400;
  color: #1d2129;
  letter-spacing: 2px;
  margin: 0 0 8px;
}
.sub-desc {
  font-size: 13px;
  color: #86909c;
  letter-spacing: 1px;
  margin: 0;
}

/* 分割线 */
.line-divider {
  width: 40%;
  margin: 0 auto 40px;
  border-color: #e5e6eb;
}

.row-wrap {
  margin-bottom: 24px;
}

/* 大卡片样式 */
.nice-card {
  background: #ffffff;
  border-radius: 16px;
  padding: 30px;
  box-shadow: 0 1px 8px rgba(0, 0, 0, 0.06);
  border: 1px solid #f0f1f3;
  transition: all 0.3s ease;
}
.nice-card:hover {
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
}
.card-label {
  font-size: 16px;
  color: #1d2129;
  font-weight: 500;
  padding-left: 8px;
  border-left: 3px solid #4477ff;
}
.card-text {
  margin-top: 18px;
  font-size: 14px;
  color: #6b7280;
  line-height: 1.8;
}

/* 三列小卡片 */
.mini-card {
  background: #ffffff;
  border-radius: 14px;
  padding: 24px;
  border: 1px solid #f0f1f3;
  box-shadow: 0 1px 6px rgba(0, 0, 0, 0.04);
  transition: all 0.3s ease;
}
.mini-card:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 14px rgba(0, 0, 0, 0.07);
}
.mini-title {
  font-size: 15px;
  color: #1d2129;
  font-weight: 500;
  margin-bottom: 10px;
}
.mini-text {
  font-size: 13px;
  color: #6b7280;
  line-height: 1.7;
}

/* 通栏卡片 */
.full-card {
  background: #ffffff;
  border-radius: 16px;
  padding: 30px;
  border: 1px solid #f0f1f3;
  box-shadow: 0 1px 8px rgba(0, 0, 0, 0.06);
}
</style>

<!--<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <h1>欢迎使用车辆大数据平台</h1>
    </el-row>
    <el-divider />
    <el-row :gutter="20">

    </el-row>
  </div>
</template>-->

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.9.2"
    }
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank")
    }
  }
}
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>
