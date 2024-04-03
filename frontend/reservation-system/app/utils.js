export function getCurrentDateTime(offset = 0){
    var currentDate = new Date();

    var year = currentDate.getFullYear();
    var month = ('0' + (currentDate.getMonth() + 1)).slice(-2);
    var day = ('0' + currentDate.getDate()).slice(-2);

    var hours = ('0' + (currentDate.getHours() + offset)).slice(-2);
    var minutes = ('0' + currentDate.getMinutes()).slice(-2);

    return year + '-' + month + '-' + day + 'T' + hours + ':' + minutes;
}