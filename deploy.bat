@echo on
call ./gradlew build
call docker image rm eb-202017487
call docker build --build-arg JAR_FILE=build/libs/*.jar -t eb-202017487 .
call docker tag eb-202017487 172122987604.dkr.ecr.us-east-1.amazonaws.com/eb-202017487
REM aws ecr get-login-password | docker login --username AWS --password-stdin 172122987604.dkr.ecr.us-east-1.amazonaws.com
call aws ecr delete-repository --repository-name eb-202017487 --region us-east-1 --force
call aws ecr create-repository --repository-name eb-202017487 --region us-east-1 >nul 2>&1
call docker push 172122987604.dkr.ecr.us-east-1.amazonaws.com/eb-202017487
REM aws ecr delete-repository --repository-name eb-202017487 --region us-east-1 --force
call aws s3 cp Dockerrun.aws.json s3://eb-202017487/Dockerrun.aws.json