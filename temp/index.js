const fs = require('fs');
// const path = require('path');
// // fs.readFile('file.txt', 'utf8', (err, data) => {
// //     if (err) {
// //         console.error('Error reading file:', err);
// //     } else {
// //         console.log(data);
// //         fs.appendFileSync('file.txt', '\nHello th again', (err) => {
// //             if (err) {
// //                 console.error('Error appending to file:', err);
// //             } else {
// //                 console.log('Content appended successfully');
// //             }
// //         });
// //     }
// // });
// // if (!fs.existsSync(destDirPath)) {
// //     fs.mkdirSync(destDirPath);
// // }

// const sourceFilePath = path.join(__dirname, 'temp', 'doit.txt');
// const destDirPath = path.join(__dirname,'temp', 'direct');
// const destFilePath = path.join(destDirPath, 'doit.txt');

// fs.copyFile(sourceFilePath, destFilePath, (copyErr) => {
//     if (copyErr) {
//         console.error('Error copying file:', copyErr);
//     } else {
//         console.log('File copied successfully');
//     }
// });


// const folderPath = path.join(__dirname, 'direct');
// console.log('Folder path:', folderPath);
// const filePath = path.join(__dirname, 'temp', 'doit.txt');
// console.log('File path:', filePath);
const {read} = require('fs');
const http = require('http');
const server = http.createServer((req, res) => {
    res.setHeader('Content-Type', 'text/html');
    res.write('<html> <head><title>Node js Class</title></head><body>');
    res.write('<h1>Welcome to Node.js class heel</h1>');
    res.write('</body></html>');
    res.end();
});
const port = 3000;
const host = 'localhost';
server.listen(port, host, () => {
    console.log(`Server is running on http://${host}:${port}`);
});