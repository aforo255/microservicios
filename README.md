# Proyecto Final - Aforo255

## Aplicación


### 1.- Microservicio de Factura (ms-test-invoice)

#### listar facturas
```shell
curl --location --request GET 'http://localhost:8005/v1/invoice/all'
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


### 3.- Microservicio de Transacciones (ms-test-transaction)

#### Listar transacciones

```shell
curl --location --request GET 'http://localhost:8082/listar'
```


### Comandos Docker

``` shel
#creacion de red:

docker network create aforo255-test

#Compilar y ejecución docker

docker build -t app-config-server .
docker build -t app-invoice .
docker build -t app-pay .
docker build -t app-transaction .

docker run -p 8888:8888 --name app-config-server --network aforo255-test -d app-config-server
docker run -p 8005:8005 --name app-invoice --network aforo255-test -d app-invoice
docker run -p 8006:8006 --name app-pay --network aforo255-test -d app-pay
docker run -p 8082:8082 --name app-transaction --network aforo255-test -d app-transaction

# Conectar servicios externos a la red aforo255-test

docker network connect aforo255-test bd-postgres12
docker network connect aforo255-test bd-mysql8
docker network connect aforo255-test servicekafka
docker network connect aforo255-test db-mongo

```

