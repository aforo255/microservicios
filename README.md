# Proyecto Final - Aforo255

## Aplicación


### 1.- Microservicio de Factura (ms-test-invoice)

#### listar facturas
```shell
curl --location --request GET 'http://localhost:8005/v1/invoice/all'
```

```json
[
    {
        "invoiceId": 1,
        "amount": 1000.00,
        "invoiceState": {
            "statusId": 1,
            "description": "Pagado"
        },
        "customer": {
            "customerId": 1,
            "fullName": "Ronaldo Sai"
        }
    },
    {
        "invoiceId": 2,
        "amount": 2000.00,
        "invoiceState": {
            "statusId": 2,
            "description": "Pendiente de Pago"
        },
        "customer": {
            "customerId": 2,
            "fullName": "Lionel Messi"
        }
    },
    {
        "invoiceId": 3,
        "amount": 3000.00,
        "invoiceState": {
            "statusId": 2,
            "description": "Pendiente de Pago"
        },
        "customer": {
            "customerId": 2,
            "fullName": "Lionel Messi"
        }
    },
    {
        "invoiceId": 4,
        "amount": 4000.00,
        "invoiceState": {
            "statusId": 2,
            "description": "Pendiente de Pago"
        },
        "customer": {
            "customerId": 3,
            "fullName": "Cristiano Ronaldo"
        }
    }
]
```


### 2.- Microservicio de Pago (ms-test-pay)

#### Realizar Pago de factura

```shell
curl --location --request POST 'http://localhost:8006/v1/pay' \
--header 'Content-Type: application/json' \
--data-raw '{
    "invoiceId": 1,
    "amount": "4000"
}'
```
