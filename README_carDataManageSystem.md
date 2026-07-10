##
carDataManageSystem是一个汽车数据管理系统，它能接入数据库并在网页中显示，运用了ruoyi框架，MySQL，redis，Kafka，zookeeper，hdfs分布式文件管理系统，yarn（Hadoop资源调度框架），能在Linux系统运行并通过IP地址实现网页的访问
##
在主页面有八个功能，分别是品牌信息，汽车类型，城市信息，城市销量前十名，燃油类型，购车人性别，汽车销量前十名，汽车总销量
##
并且使用redis和Kafka做出实时显示大屏，可显示汽车总销量，城市销量等信息，还可以通过post形式提交数据到MySQL实现数据库的更新
##
