# Secure Database Access Project

This project is a REST-based web application developed using Java and Spring Boot. It demonstrates secure database access using HTTPS, Spring Security, Spring Data JPA, and BCrypt password hashing.

## Security Features

- HTTPS on port 8443
- Spring Security authentication
- BCrypt password hashing
- Spring Data JPA for secure database access
- Protected `/api/users` endpoints
- H2 database for testing

## HTTPS KeyStore

The `keystore.p12` file is excluded from this repository because it contains private key material.

To generate the KeyStore for local testing, run the following command inside `src/main/resources`:

```bash
keytool -genkeypair -alias secureapp -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 365
```

Use `changeit` as the KeyStore password to match the project configuration.

## Run the Application

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs at:

`https://localhost:8443`

Protected API endpoint:

`https://localhost:8443/api/users`
