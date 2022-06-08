# List of Payments

## Checkpoints
* [x] Have /health endpoint;
* [x] Storing data in h2 database;
* [x] Have 100% coverage;
* [x] Dockerfile generated.

## [POST] /credits
### Input
```
{
"amount": 100,
"terms": 4,
"rate": 10
}
```
### Output
```
{
    "id": 1,
    "amount": 100.0,
    "terms": 4,
    "rate": 10.0,
    "payments": [
        {
            "id": 1,
            "paymentNumber": 1,
            "amount": 27.5,
            "paymentDate": "2022-07-08T17:24:37.651+00:00",
            "credit": null
        },
        {
            "id": 2,
            "paymentNumber": 2,
            "amount": 27.5,
            "paymentDate": "2022-08-07T17:24:37.651+00:00",
            "credit": null
        },
        {
            "id": 3,
            "paymentNumber": 3,
            "amount": 27.5,
            "paymentDate": "2022-09-06T17:24:37.651+00:00",
            "credit": null
        },
        {
            "id": 4,
            "paymentNumber": 4,
            "amount": 27.5,
            "paymentDate": "2022-10-06T17:24:37.651+00:00",
            "credit": null
        }
    ]
}
```

## [GET] /credits

### Output
```
[
    {
        "id": 1,
        "amount": 100.0,
        "terms": 4,
        "rate": 10.0,
        "payments": [
            {
                "id": 1,
                "paymentNumber": 1,
                "amount": 27.5,
                "paymentDate": "2022-07-08T17:24:37.651+00:00",
                "credit": null
            },
            {
                "id": 2,
                "paymentNumber": 2,
                "amount": 27.5,
                "paymentDate": "2022-08-07T17:24:37.651+00:00",
                "credit": null
            },
            {
                "id": 3,
                "paymentNumber": 3,
                "amount": 27.5,
                "paymentDate": "2022-09-06T17:24:37.651+00:00",
                "credit": null
            },
            {
                "id": 4,
                "paymentNumber": 4,
                "amount": 27.5,
                "paymentDate": "2022-10-06T17:24:37.651+00:00",
                "credit": null
            }
        ]
    }
]
```

## [GET] /payments

### Output
```
[
    {
        "id": 1,
        "paymentNumber": 1,
        "amount": 27.5,
        "paymentDate": "2022-07-08T17:24:37.651+00:00",
        "credit": {
            "id": 1,
            "amount": 100.0,
            "terms": 4,
            "rate": 10.0,
            "payments": null
        }
    },
    {
        "id": 2,
        "paymentNumber": 2,
        "amount": 27.5,
        "paymentDate": "2022-08-07T17:24:37.651+00:00",
        "credit": {
            "id": 1,
            "amount": 100.0,
            "terms": 4,
            "rate": 10.0,
            "payments": null
        }
    },
    {
        "id": 3,
        "paymentNumber": 3,
        "amount": 27.5,
        "paymentDate": "2022-09-06T17:24:37.651+00:00",
        "credit": {
            "id": 1,
            "amount": 100.0,
            "terms": 4,
            "rate": 10.0,
            "payments": null
        }
    },
    {
        "id": 4,
        "paymentNumber": 4,
        "amount": 27.5,
        "paymentDate": "2022-10-06T17:24:37.651+00:00",
        "credit": {
            "id": 1,
            "amount": 100.0,
            "terms": 4,
            "rate": 10.0,
            "payments": null
        }
    }
]
```