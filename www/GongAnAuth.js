var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'GongAnAuth', 'coolMethod', [arg0]);
};
exports.StartAuth = function(sfzh, xm, sjh, mm, success, error){
    exec(success, error,'GongAnAuth', 'StartAuth',[ sfzh, xm, sjh, mm]);
}