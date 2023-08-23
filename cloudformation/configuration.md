## Create Certificate

Execute the following command

```
aws cloudformation create-stack --stack-name CertificateStack --template-body file://certificate-template.yaml --parameters ParameterKey=DomainName,ParameterValue=yourdomain.com
```

Replace the value of yourdomain.com with the actual domain