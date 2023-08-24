## Create Certificate

Execute the following command

```
aws cloudformation create-stack --stack-name CertificateStack --template-body file://certificate-template.yaml --parameters ParameterKey=DomainName,ParameterValue=yourdomain.com
```

Replace the value of yourdomain.com with the actual domain

## Configure Cognito

Execute the following command

```
aws cloudformation create-stack --stack-name CognitoBidBinding --template-body file://cognito-template.yaml --parameters ParameterKey=AuthName,ParameterValue=bidbindingauth ParameterKey=DomainName,ParameterValue=bidbinding.com --capabilities CAPABILITY_IAM CAPABILITY_NAMED_IAM
```