# poc-crm-catalog

# initial
`mvn clean install`

## build image
`docker image build -t poc-catalog .`


## run container
`docker container run -d -p 8080:8080 poc-catalog`