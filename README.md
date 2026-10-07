# First App

A Spring Boot REST API that adds two whole numbers.

## Run the application

From the project directory, run:

```powershell
.\mvnw.cmd spring-boot:run
```

## Call the API from a browser

With the application running, open this URL:

```text
http://localhost:8080/api/add?a=2&b=3
```

The browser displays:

```json
{"sum":5}
```

The `a` and `b` query parameters are required whole numbers. For example, `/api/add?a=-2&b=3` returns `{"sum":1}`.
