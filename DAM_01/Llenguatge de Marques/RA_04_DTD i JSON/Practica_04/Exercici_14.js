const Ajv = require('ajv');
const ajv = new Ajv();
const schema = require('./Exercici_14.json');
const data = require('./Exercici_14_2.json');
const validate = ajv.compile(schema);
const valid = validate(data);
if (valid) {
console.log('El JSON és vàlid!');
} else {
console.error('Errors de validació:', validate.errors);
}