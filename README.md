## Deploying

When doing anything with the gcloud CLI, remember to switch your project to the correct gcloud project

```
gcloud config set project YOUR_PROJECT_ID
```

### Push Image to Registry

```
# Build the project / create the .jar
mvn clean package 

# Run from the directory that your Dockerfile is in
gcloud builds submit --tag gcr.io/YOUR_PROJECT_ID/your-app
```

- The YOUR_PROJECT_ID can be found in the top nav bar of the Google Cloud Console
-

## Deploy Image to a Service

- When you want to deploy, create a Service and choose the latest image for your-app
- You'll need to provide a few environment variables to be set in the container once it's running:
- These will map to variables in application.properties or are expected by Spring
    - Spring Env Variables - Environment variables that Spring expects
        - SPRING_PROFILES_ACTIVE = prod
    - User-defined environment variables - Environment variables that we could have named anything, and reference in
      application.properties
        - DB_USER = your-db-user
        - DB_PASS = your-db-password
        - INSTANCE_CONNECTION_NAME = your-project:us-central1:pizza-vote-db