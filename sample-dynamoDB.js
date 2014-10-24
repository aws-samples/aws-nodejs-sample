/*
 * Copyright 2013. Jesus García. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
**/

// Load the SDK and UUID
var AWS = require('aws-sdk');

//Set the region
AWS.config.update({region: 'us-east-1'});

//Create the DynamoDB Instance
var dyn= new AWS.DynamoDB({ endpoint: new AWS.Endpoint('http://localhost:8000') });

//Do a query
dyn.listTables(function (err, data)
{
   console.log('listTables',err,data);
});
