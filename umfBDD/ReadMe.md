# 简介

## 背景
我的使用testng编写自动化测试工具的时候，想到了验证的目的是为了满足业务的需求，此前曾经使用过Cucumber进行BDD的测试练习，但是语法有点生硬，没有引入到团队中，这次使用Concordion作为BDD的底层框架，因为其提供的文档语言更趋于自然语言，对产品团队拆分需求的要求较低，而且文档呈现的效果更好。

## BDD驱动开发示例及使用说明
我取了一段跨境收银台的产品文档，提供了原有的文档和新的文档比对的编写方式，下载工程后，通过Maven进行编译测试，然后在target/concordion/com/umpay/test/bdd/Crossborder.html入口查看文档。
文档中我粘贴了原始文档，及以BDD分解后的需求文档，并提供了调用Oauth测试的验证数据，这里我想要说明一下，实际项目中，最初的BDD文档应该是具备完整的验收目标且包含数据的，但是验证的结果可以是失败的，最终完成的代码将全部的验收要求执行通过，视为项目目标的达成，这里就特别强大大家有批判性思维，也就是站在产品、技术、测试、运维、运营各个维度去思考产品如何验证，还有哪些非功能性需要验证了。

## 工程说明
我提供了Concordion的基本能力，及用例耗时统计、Excel表格的扩展示例。更多内容请参阅
[Concordion的官方文档](http://concordion.org/tutorial/java/markdown/)。

Concordion采用[markdown语法](http://www.markdown.cn/)编写业务驱动文档。

基本信息：
1. src/test目录下编写测试用例，如com.umpay.test.bdd.CrossborderFixture.java
1. 类文件命名规范：可以是**Crossborder.java、CrossborderFixture.java、CrossborderTest.java**
1. src/test/resources目录下，创建于类同目录结构且名称相同的markdown文档，如 com/umpay/test/bdd/Crossborder.md
1. 文档命名规范：与类名相同，只是扩展名为md
1. 工程POM文件中引用concordion，并且需要使用jdk1.8，工程中所有测试类继承了BaseFixture，将支持测试耗时统计和并行测试能力
1. 与jUnit最大的区别是，concordion的测试用例需要在markdown文档中关联，并且被文档主动使用。

## Concordion 示例
我测试了一下Concordion，并在github中放了一个[Concordion使用示例](https://github.com/thomas0927/ConcordionDemo)。
