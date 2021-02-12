# graphql-vehicle-crud
Below are some  queries which can be run on GraphiQl interface 

1st open GraphiQl in any browser by http://localhost:8080/graphiql (to check service is runnimg or not) then proceed with queries: 

query{ 

  vehicles(count: 8) { 

    id 

    type 

    brandName 

  } 

} 
******************
query{ 

  vehicle(id: 2) { 

    id 

    type 

    brandName 

  } 

} 
****************** 

mutation { 

  createVehicle(type: "car", modelCode: "XYZ0192", launchDate: "2016-08-16")  

  { 

    id 

  } 

} 

*********************** 

mutation($input: UpdateVehicleInput!) { 

    updateVehicle(input: $input){ 

    id 

    type 

    modelCode 

  } 

} 

And in query variable as -  {"input": {"id": 2, "type": "Actibbbva", "modelCode": "51"}}  

****************** 

mutation($id: ID!){ 

deleteVehicle(id: $id) 

}  

And in query variable as : {"id":2} 
*****************
