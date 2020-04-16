# Introducción

Ejemplos progresivos para aprender Inyección de dependencias sin Spring, Spring y Spring Boot.

# Requerimientos

Es necesario instalar mongodb y un cliente como Robo3T:
```sh
sudo apt install mongodb-server
sudo snap install robo3t-snap
```
Después hay que conectar a mongodb con Robo 3T, crear la base de datos "demoDb" y una colección llamada "programmers".  
Dentro de esta colección hay que insertar varios datos de prueba, como por ejemplo:
```json
{
    "username" : "iperez",
    "name" : "Íñigo Montoya",
    "age" : 38
},
{
    "username" : "lcroft",
    "name" : "Lara Croft",
    "age" : 27
}
```
