# Práctica_1 - Sistema de Gestión de Biblioteca

## Integrantes del Grupo
* **Iker Albizu**
* **Nerea Fresnedo**
* **Ibai López de Lerena**
* **Alejandro Sierra**
---
## Descripción Breve y Funcionalidades
Este proyecto consiste en un sistema de gestión de biblioteca orientada a objetos. El sistema permite administrar de manera centralizada usuarios, préstamos y diferentes tipos de recursos multimedia.

### Funcionalidades principales:
* **Gestión de Recursos Multimedia:** Administración e integración de Libros, Películas y Videojuegos mediante un modelo de herencia.
* **Gestión de Usuarios:** Registro y administración de datos de los usuarios de la biblioteca.
* **Gestión de Préstamos:** Registro, asignación y seguimiento de préstamos asociados a usuarios y recursos.
* **Búsquedas y Consultas:** Búsqueda avanzada de catálogo y consultas específicas según criterios parametrizados.
* **Persistencia de Datos:** Métodos integrados para guardar y recuperar la información del sistema.
---
## Estructura General del Proyecto
El diseño del software sigue una arquitectura orientada a objetos organizada de la siguiente manera:

* **`Biblioteca` (Clase Principal / `Main`):** Punto de entrada de la aplicación y orquestador central del sistema. Conecta e interactúa con el resto de las clases del programa.
* **`Recursos` (Clase Base / Herencia):** Clase abstracta/padre que define los atributos y comportamientos comunes para los distintos elementos de la biblioteca:
  * `Libro`
  * `Pelicula`
  * `Videojuego`
* **`Usuario`:** Clase encargada de la gestión y representación de los usuarios dentro del sistema.
* **`Prestamo`:** Clase encargada de gestionar la lógica de los préstamos, conectando los recursos solicitados con sus respectivos usuarios.

---

##  Instrucciones para Ejecutarlo

1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DEL_REPOSOTORIO>
   cd Practica_1
   ```

2. **Compilación y Ejecución:**
   * Abre el proyecto en tu entorno de desarrollo (IDE) preferido (p. ej., Eclipse, IntelliJ IDEA, NetBeans, Visual Studio Code).
   * Localiza la clase principal **`Biblioteca`** (contiene el método `main`).
   * Compila y ejecuta la clase `Biblioteca` para iniciar la aplicación interactiva.

---

##  Reparto Inicial del Trabajo

* **Alejandro Sierra:**
  * Configuración inicial de la estructura del repositorio en GitHub.
  * Supervisión y resolución de fusiones (*merges*) de código.
  * Desarrollo e implementación de la funcionalidad de consultas.

* **Ibai López de Lerena:**
  * Diseño e implementación de la clase `Prestamo` junto con sus métodos correspondientes.

* **Nerea Fresnedo:**
  * Diseño e implementación de la clase `Usuario` junto con sus métodos asociados.

* **Iker Albizu:**
  * Desarrollo e implementación de la clase `Biblioteca` (método principal `main`), encargada de conectar y orquestar las diferentes partes de la aplicación.

---

## Problemas Relevantes Encontrados Durante el Desarrollo

Durante la realización del proyecto, las principales dificultades se centraron en la gestión del control de versiones y el trabajo colaborativo:

1. **Configuración Inicial del Repositorio:** Presentó ciertos contratiempos durante las primeras etapas del proyecto para asegurar un entorno de trabajo unificado entre todos los integrantes.
2. **Conflictos en Git (*Merge Conflicts*):** Al trabajar simultáneamente varios desarrolladores sobre la misma base de código y proyecto, surgieron múltiples conflictos de código al fusionar las ramas. Esto requirió un aprendizaje acelerado sobre la resolución de conflictos en GitHub para asegurar la integridad del software y mantener la estabilidad del proyecto.
