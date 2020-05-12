# Spring Boot CI/CD with Docker, GitHub Actions and AWS

#### Template for a dockerized Spring Boot app with hot-reloading and remote debugging in development and continuous delivery to Amazon Web Services with a GitHub Actions custom workflow

![CI](https://github.com/GomezOrtiz/docker-spring-boot-template/workflows/CI/badge.svg)
![CD](https://github.com/GomezOrtiz/docker-spring-boot-template/workflows/CD/badge.svg)

### DEVELOPMENT

When using **Docker containers for Spring Boot** development, one of the main caveats is losing hot-reloading and debugging capabilities. We have addressed this issue by leveraging Docker volumes to allow Gradle to detect any change in source code and rebuild the app in real-time inside the container. 

Moreover, you can debug your dockerized app in your IDE of choice thanks to remote debugging. Port 5005 will be exposed and listening in your app's container for a remote debugger to be attached in [Eclipse/STS](https://docs.alfresco.com/5.2/tasks/sdk-debug-eclipse.html) or [Intellij Idea](https://docs.alfresco.com/5.2/tasks/sdk-debug-intellij.html).

To start developing with Docker, run this command:

`make up`

Alternatively, if you also want to see the logs in terminal:

`make up logs`

To stop the containers and check that they have been succesfully removed:

`make down status`

Please note that **you can also run your app as usual from your IDE** of choice with the **bootRun** Gradle task, which has been modified to check if the required containers (right now, Postgres, Adminer and Rabbit) are already up and running. Gradle itself will run those containers for you if they are not available.

### PRODUCTION: CONTINUOUS INTEGRATION AND DELIVERY

We have defined two GitHub Workflows for CI and CD, respectively. The first will run the tests any time a push or pull request is made to any branch. The second will build and image of your app for production any time a new release is created in GitHub,  publish that image to Amazon ECR and deploy it to Amazon ECS as a task in a predefined service and cluster (you can modifiy any configuration in .github/workflows/cd.yml and task-definition.json). 

For all this to work, you also must define two variables in the Secrets tab of your GitHub repository settings: AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY.

Please note that the task-definition.json, which describes how the container is going to be created in Amazon ECS, is referencing some secrets that are required for the production application to run properly (Postgres and RabbitMQ login and configuration data). [You must provide your own values by using](https://aws.amazon.com/es/premiumsupport/knowledge-center/ecs-data-security-container-task/), for example, AWS Systems Manager Parameter Store (which is included in the free tier) or AWS Secrets Manager (which is a paid service).

### SOMETHING TO SHARE?

If you have any questions or suggestions on how to improve this template for Docker with Spring Boot apps and GitHub Actions CI/CD with Amazon Web Services, you can reach me at [david.gomez.mail@gmail.com](mailto:david.gomez.mail@gmail.com).