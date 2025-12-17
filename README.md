https://github.com/gechtwitchaa/PC-CasoPractico5.git
# PC-CasoPractico5
# Caso Práctico Unidad 5: Microservicios en la Ciudad de Wakanda

### Miembros del Grupo
* **Nombre:** Chahla Bouchotroch - Alberto González Olmedo

---

## Lógica de la Solución
La solución implementa una arquitectura de microservicios para la gestión inteligente de tráfico. Se basa en tres pilares fundamentales:
1.  **Descubrimiento (Service Discovery):** Un servidor Eureka centraliza el registro de todos los servicios, permitiendo una comunicación dinámica sin IPs fijas.
2.  **Enrutamiento (API Gateway):** Un punto de entrada único que centraliza las peticiones externas y las redirige al microservicio adecuado.
3.  **Resiliencia (Circuit Breaker):** Se utiliza **Resilience4j** para detectar fallos en el servicio de tráfico y activar un método de respaldo (*fallback*), garantizando la continuidad del servicio.

---

## Archivos de Relevancia para la Solución

### Infraestructura
* **`docker-compose.yml`**: Orquestador que define los contenedores, redes y dependencias del sistema completo.
* **`Dockerfile`**: Archivo de configuración para crear la imagen de cada microservicio con Java 17.

###  API Gateway (Puerto 8080)
* **`api-gateway/src/main/resources/application.yml`**: Contiene la definición de rutas y el filtro *StripPrefix* para limpiar las URLs antes de enviarlas a los servicios.

###  Eureka Server (Puerto 8761)
* **`eureka-server/src/main/resources/application.yml`**: Configuración del servidor de nombres donde se "anuncian" los demás microservicios.

###  Servicio de Tráfico
* **`servicio-trafico/src/main/java/.../TraficoController.java`**: Controlador que gestiona la lógica del tráfico y define el `@CircuitBreaker` con su método de plan B.
* **`servicio-trafico/src/main/resources/application.yml`**: Configuración del nombre del servicio y parámetros específicos de resiliencia.

---

## Instrucciones de Inicio Rápido
1. Generar los archivos JAR ejecutando `mvn clean package` en cada proyecto.
2. Iniciar la infraestructura con `docker-compose up --build` desde la raíz.
