# 单时校验商户请求参数

1. 一个子订单代表商户端的一个商品订单。允许一笔支付订单中包含多个子订单，一笔订单的子单个数满足：1<=子单个数<=10。一个子订单中，至少包含一个订单号、一个子订单金额、一个交易编码。

### [验证子订单信息](- "example 1")

输入 [Andrew]( - "#paymentObject") 名字验证结果为 [valid](- "c:assert-true=checkPaymentObject(#paymentObject)").

输入 [David]( - "#paymentObject") 名字验证结果为 [valid](- "c:assert-true=checkPaymentObject(#paymentObject)").

输入 [Steven]( - "#paymentObject") 名字验证结果为 [valid](- "c:assert-true=checkPaymentObject(#paymentObject)").

输入 [Stephen]( - "#paymentObject") 名字验证结果为 [valid](- "c:assert-true=checkPaymentObject(#paymentObject)").

输入 [12345]( - "#paymentObject") 名字验证结果为 [valid](- "c:assert-false=checkPaymentObject(#paymentObject)").

输入 Empty String 名字验证结果为 [invalid](- "c:assert-false=checkPaymentObjectAsEmptyString()").

输入 null 名字验证结果为 [invalid](- "c:assert-false=checkPaymentObjectAsNull()").

输入 [Pr@sh@nt]( - "#paymentObject") 名字验证结果为 [invalid](- "c:assert-false=checkPaymentObject(#paymentObject)").


1.	货物类的子订单中还需按照货物品类进行划分。一个子订单中，包含多种单品。每种单品对应一个商品编号、一个订单子类型、一个商品金额。（货物类按单品进行分类的原因：外管局客户月报表中要求将货物类别商品细分为四个子类型。）
1.	金额校验：

	（１）订单金额＝各子订单金额之和；
	（２）（货物类）子订单金额＝同一子订单下各商品金额之和。
1.	订单币种为外币时，UMP需根据交易汇率计算订单人民币金额，将交易汇率与订单人民币金额返回给商户。金额用途：

	（１）支付订单中，用户实际应支付的人民币金额；
	（２）扣除手续费后为实时结算到U付的金额；
	（３）清结算时，扣除手续费后为人民币计价商户的应购汇人民币金额。
1.	商户下单后，UMP在返回在获取验证码时应提交的支付要素时，信用卡快捷应返回姓名、身份证号、卡号、手机号、有效期、CVV2，借记卡快捷应返回姓名、身份证号、卡号、手机号。

