# Template Email Sending

Access with a REST client of your choice and include in the post body something like
```json
{"template": "It's {0}", 
  "recipientSubstitutions": {"potus@whitehouse.gov":["Great!"]}
}
```

Make sure you set `Content-Type` to `application/json`