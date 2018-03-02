# 从UMF获取Token

### [获取Token；](- "authorize and get token")
| [authorize][][说明](- "c:example")	| [验证环境][uri] 											 | [测试商户的授信密钥][client_secret] 					| [测试商户的授信id][client_id] 		  							| [验证认证结果][ret_code]	|
| ---------------                     | -------------   											 | -------------       											| ---------------     											| ---------------   			|
| UAT有效商户下单                        | https://uatfx-us.soopay.net/cberest/v1|16f5ad6db5d67ca6edb0cdbe713a632026723456|7ddb69c8ff5554701445f83891c2679c5d257df| 0000          					|
| 生产有效商户下单                				| https://fxus.soopay.net/cberest/v1|97a59ad7630390314e679f736723a2cc5755ed9f|ef688da56871f8df06e82a0fccd3dd658cbc6f54| 0000   				|

[authorize]: - "#result = authorize(#uri,#client_secret,#client_id)"
[uri]: - "#uri"
[client_secret]: - "#client_secret"
[client_id]: - "#client_id"
[ret_code]:  - "?=#result.meta.retCode"