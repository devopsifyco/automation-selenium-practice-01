FROM openjdk:20-jdk-alpine

# Args
ARG BUILD_DATE
ARG REVISION
ARG BUILD_VERSION
ARG GIT_COMMIT
ARG GIT_URL
ARG GIT_BRANCH
ARG BUILD_NUMBER
ARG BUILD_URL
ARG JAR_FILE=target/automation-selenium-practice-01.jar

# Labels
LABEL maintainer="DevOpsify Community <support@devopsify.co>"
LABEL \
    org.opencontainers.image.authors="DevOpsify <info@devopsify.co>" \
    org.opencontainers.image.created=$BUILD_DATE \
    org.opencontainers.image.title="automation-selenium-practice-01" \
    org.opencontainers.image.description="Image build from DevOpsify" \
    org.opencontainers.image.url="https://devopsify.co/?s=angular" \
    org.opencontainers.image.vendor="DevOpsify" \
    org.opencontainers.image.revision=$REVISION \
    org.opencontainers.image.version=$BUILD_VERSION \
    GIT_COMMIT="${GIT_COMMIT}" \
    GIT_URL="${GIT_URL}" \
    GIT_BRANCH="${GIT_BRANCH}" \
    BUILD_NUMBER="${BUILD_NUMBER}" \
    BUILD_URL="${BUILD_URL}"

# Main conent
WORKDIR /home
COPY .ci/entrypoint.sh /entrypoint.sh
COPY ${JAR_FILE} /home/app.jar
EXPOSE 80
EXPOSE 443
ENTRYPOINT [ "sh","/entrypoint.sh"]