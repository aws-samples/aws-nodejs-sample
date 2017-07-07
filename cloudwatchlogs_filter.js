// Load the SDK and UUID
var AWS = require('aws-sdk');
var uuid = require('node-uuid');

AWS.config.loadFromPath('config.json');

// Create an CloudWatchLog client
var cloudwatchlogs = new AWS.CloudWatchLogs();


var params = {
  logGroupName: 'API-Gateway-Execution-Logs_9upfn6zpoe/Sample2', /* required */
  filterPattern: 'GET',
  interleaved: true || false,
  limit: 100,
  logStreamNames: [
    '4c56ff4ce4aaf9573aa5dff913df997a',
      'c45147dee729311ef5b5c3003946c48f',
      '4e732ced3463d06de0ca9a15b6153677',
      'cfecdb276f634854f3ef915e2e980c31'
    /* more items */
  ]
};
cloudwatchlogs.filterLogEvents(params, function(err, data) {
  if (err) console.log(err, err.stack); // an error occurred
  else     console.log(data);           // successful response
});