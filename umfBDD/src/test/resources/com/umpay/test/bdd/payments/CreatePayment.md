# 5.2.2.1	下单流程

## 流程说明：

1. 新商户请联系运营人员**开通商户产品关系**，开通后会拿到商户用于向UMF发起交易的相关证书和用于Oauth2认证的信息。
1. 开通商户产品关系的商户在第一次请求或者当token过期时，[需要先从UMF获取Oauth认证](OauthAuthorize.md "c:run")认证通过后才能进行后续交易。
1. UMP[校验商户请求参数](ValidOrderParameters.md "c:run")，数据校验通过后创建订单。
1. [判断订单币种](CheckCurrency.md "c:run")是否为外币，为外币则UMP需要[查询交易汇率](CalculateRate.md "c:run")，计算订单人民币金额；为人民币则跳过此步；
1.	如果是银行卡直连，UMP通道商户上传的支付方式（信用卡、借记卡、微信、支付宝...见下面需求说明）进行[路由查询]()，获得通道属性并返回商户支付时需要上送的具体信息；
1.	向商户返回U付订单号及全量支付要素名称；（返回全量，确保UMP能从商户处收集外管局所需的四要素）**如果细心整理，我们不难看出这条需求和前一条是冲突的，如果我们总是收集全量数据，查通道就失去了意义反而消耗资源**

> 总结：
> 这里我提供了Oauth认证这个调用的具体示例，并标注了一些产品需求中需要进行验收的行为，每一个行为都可以进行扩展编写相应的业务要求及验证标准，从而在形成产品需求的同时，明确了验收范围和标准，使得产品、技术、运营乃至运维尽早达成共识。

