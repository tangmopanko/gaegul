#!/bin/bash
set -ex

_ecr_upload=false
_base_env='dev stag stg'
_env=dev
_appName=''

export AWS_PROFILE=admin

if [ $# -ne 2 ]; then
 echo "Usage: $0 : requires exactly 2 arguments.  ex -> dk_build.sh test-app 1.0"
 exit 1 
else 
 # validation: env 
 if [[ "$_base_env" == *"$_env"* ]]; then
  _result=true
  _appName=$1'-'$_env':'$2
  docker build -t $_appName . 
 else 
    echo "Usage: _env in [dev or stage or stg]"
    exit 1 
 fi 
fi

if $_ecr_upload; then 
 aws ecr get-login-password --region ap-northeast-2 --profile admin | docker login --username AWS --password-stdin 143708603037.dkr.ecr.ap-northeast-2.amazonaws.com
 docker tag $_appName 143708603037.dkr.ecr.ap-northeast-2.amazonaws.com/$_appName
 docker push 143708603037.dkr.ecr.ap-northeast-2.amazonaws.com/$_appName
fi 

#_image_id=$(docker images --format '{{.ID}}\t{{.Repository}}:{{.Tag}}' | grep $1:$2 | awk '{print $1}')
# https://docs.aws.amazon.com/AmazonECR/latest/userguide/getting-started-cli.html

# aws ecr create-repository \
#    --repository-name gaegul-dev \
#   --image-scanning-configuration scanOnPush=true \
#    --region ap-northeast-2 

