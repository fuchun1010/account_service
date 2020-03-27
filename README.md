```text
account service for money management
```

> 预扣账户资金

```text
curl -XPOST "http://localhost:10999/account_service/v1/preSubMoney" -H "Content-Type:application/json" -d '
{
  "app": "order_service",
  "xid": "s0001",
  "money": 100,
  "accountId": 1
}
'
```

`body`

```json
{
  "app": "order_service",
  "xid": "s0001",
  "money": 100,
  "accountId": 1
}
```

> 扣减账户资金

```text
curl -XPOST "http://localhost:10999/account_service/v1/confirmMoney" -H "Content-Type:application/json" -d '{
    "xid": "s0001"
}'
```

```json
{
  "xid": "s0001"
}
```
