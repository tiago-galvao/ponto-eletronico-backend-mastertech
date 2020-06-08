# Gestão de ponto eletronico  
## Listagem de todos usuarios da base de dados  

#### GET /usuario  
**Exemplo GET:**  
##### Response Body  
```json
[
  {
    "id": 1,
    "nome": "Tiago",
    "email": "tiago@email.com",
    "dataCadastro": "2020-06-08T05:28:27.940419"
  },
  {
    "id": 2,
    "nome": "Nataly",
    "email": "nataly@gmail.com",
    "dataCadastro": "2020-06-08T05:30:42.940419"
  }
]
```
## Consulta usuário por id 
#### GET /usuario/:id   
**Exemplo GET :ID:**
##### Response Body  
```json
{
  "id": 2,
  "nome": "Nataly",
  "email": "nataly@gmail.com",
  "dataCadastro": "2020-06-08T05:39:02.821049"
}
```
## Cadastro de usuario  
#### POST /usuario  
**Exemplo POST:**
   **Headers:**  
&nbsp;&nbsp;&nbsp;&nbsp;Content-Type = application/json  
   **Body:**  
```json
{
	"nome" : "Nataly",
	"email" : "nataly@gmail.com",
	"senha" : "123"
}
```
**nome**&nbsp;&nbsp;&nbsp;&nbsp;String  
**email**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String  
**senha**&nbsp;&nbsp;&nbsp;&nbsp;String  

##### Response Body  
```json
{
  "id": 2,
  "nome": "Nataly",
  "email": "nataly@gmail.com",
  "dataCadastro": "2020-06-08T05:39:02.821049"
}
```

## Atualizar usuario  
#### PUT /usuario/:id  

**Exemplo PUT:**   
   **Headers**  
&nbsp;&nbsp;&nbsp;&nbsp;Content-Type = application/json  
   **Body**  
```json
{
	"nome": "Natalyyy",
	"email" : "natalyyy@gmail.com",
	"senha" : "123"
}
```
**nome**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String  
**email**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String  
**senha**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String  

##### Response Body  
```json
{
  "id": 2,
  "nome": "Natalyyy",
  "email": "natalyyy@gmail.com",
  "dataCadastro": "2020-06-08T05:39:02.821049"
}
```
 

## Listagem de pontos batidos  
#### GET /pontoEletronico  
**Exemplo GET:** 
##### Response Body  
```json
[
  {
    "id": 1,
    "statusBatidaPonto": "ENTRADA",
    "dataBatidaPonto": "2020-06-08T05:46:03.492984",
    "usuario": {
      "id": 2,
      "nome": "Natalyyy",
      "email": "natalyyy@gmail.com",
      "senha": "123",
      "dataCadastro": "2020-06-08T05:39:02.821049"
    }
  },
  {
    "id": 2,
    "statusBatidaPonto": "SAIDA",
    "dataBatidaPonto": "2020-06-08T05:46:08.184349",
    "usuario": {
      "id": 2,
      "nome": "Natalyyy",
      "email": "natalyyy@gmail.com",
      "senha": "123",
      "dataCadastro": "2020-06-08T05:39:02.821049"
    }
  },
  {
    "id": 3,
    "statusBatidaPonto": "ENTRADA",
    "dataBatidaPonto": "2020-06-08T05:46:13.642777",
    "usuario": {
      "id": 2,
      "nome": "Natalyyy",
      "email": "natalyyy@gmail.com",
      "senha": "123",
      "dataCadastro": "2020-06-08T05:39:02.821049"
    }
  },
  {
    "id": 4,
    "statusBatidaPonto": "SAIDA",
    "dataBatidaPonto": "2020-06-08T05:46:18.397532",
    "usuario": {
      "id": 2,
      "nome": "Natalyyy",
      "email": "natalyyy@gmail.com",
      "senha": "123",
      "dataCadastro": "2020-06-08T05:39:02.821049"
    }
  }
]
```

## Batendo ponto  
#### POST /ponto/idUsuario/:id  
**Exemplo POST/:ID**  
   **headers**  
&nbsp;&nbsp;&nbsp;&nbsp;Content-Type = application/json  
   **Body**  
```json
{
	"statusPonto":"SAIDA"
}
```
**statusPonto**&nbsp;&nbsp;&nbsp;&nbsp;String  
##### Response Body  
```json
{
  "id": 4,
  "statusBatidaPonto": "SAIDA",
  "dataBatidaPonto": "2020-06-08T05:46:18.397532",
  "usuario": {
    "id": 2,
    "nome": "Nataly",
    "email": "nataly@gmail.com",
    "senha": "123",
    "dataCadastro": "2020-06-08T05:39:02.821049"
  }
}
```