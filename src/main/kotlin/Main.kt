import org.intellij.lang.annotations.Language

fun main() {

    val ref = "\$ref"

    @Language("json")
    val openApi = """
      {
        "openapi": "3.0.3",
        "info": {
          "title": "Api Documentation",
          "description": "Api Documentation",
          "termsOfService": "urn:tos",
          "contact": {},
          "license": {
            "name": "Apache 2.0",
            "url": "http://www.apache.org/licenses/LICENSE-2.0"
          },
          "version": "1.0"
        },
        "servers": [
          {
            "url": "https://localhost",
            "description": "Inferred Url"
          }
        ],
        "tags": [
          {
            "name": "some-management-service",
            "description": "Some Management Service"
          },
          {
            "name": "some-service",
            "description": "Some Service"
          }
        ],
        "paths": {
          "/some": {
            "post": {
              "tags": [
                "some-management-service"
              ],
              "summary": "Store a document",
              "operationId": "createSome",
              "requestBody": {
                "content": {
                  "application/json": {
                    "schema": {
                      "$ref": "#/components/schemas/Some"
                    }
                  }
                }
              },
              "responses": {
                "201": {
                  "description": "Created",
                  "content": {
                    "application/json": {
                      "schema": {
                        "$ref": "#/components/schemas/Some"
                      }
                    }
                  }
                },
                "400": {
                  "description": "Bad Request"
                }
              }
            }
          },
          "/some/{id}": {
            "get": {
              "tags": [
                "some-management-service"
              ],
              "summary": "Retrieve a document by id",
              "operationId": "getSomeById",
              "parameters": [
                {
                  "name": "id",
                  "in": "path",
                  "description": "id",
                  "required": true,
                  "style": "simple",
                  "schema": {
                    "type": "string",
                    "format": "uuid"
                  }
                }
              ],
              "responses": {
                "200": {
                  "description": "OK",
                  "content": {
                    "application/json": {
                      "schema": {
                        "$ref": "#/components/schemas/Some"
                      }
                    }
                  }
                },
                "404": {
                  "description": "Not Found"
                }
              }
            },
            "put": {
              "tags": [
                "some-management-service"
              ],
              "summary": "Update a document",
              "operationId": "putSomeById",
              "parameters": [
                {
                  "name": "id",
                  "in": "path",
                  "description": "id",
                  "required": true,
                  "style": "simple",
                  "schema": {
                    "type": "string",
                    "format": "uuid"
                  }
                }
              ],
              "requestBody": {
                "content": {
                  "application/json": {
                    "schema": {
                      "$ref": "#/components/schemas/Some"
                    }
                  }
                }
              },
              "responses": {
                "200": {
                  "description": "OK",
                  "content": {
                    "application/json": {
                      "schema": {
                        "$ref": "#/components/schemas/Some"
                      }
                    }
                  }
                },
                "400": {
                  "description": "Bad Request"
                }
              }
            },
            "delete": {
              "tags": [
                "some-management-service"
              ],
              "summary": "Delete a document",
              "operationId": "deleteSomeById",
              "parameters": [
                {
                  "name": "id",
                  "in": "path",
                  "description": "id",
                  "required": true,
                  "style": "simple",
                  "schema": {
                    "type": "string",
                    "format": "uuid"
                  }
                }
              ],
              "responses": {
                "204": {
                  "description": "No Content"
                },
                "404": {
                  "description": "Not Found"
                }
              }
            }
          }
        },
        "components": {
          "schemas": {
            "Some": {
              "title": "Some",
              "required": [
                "some"
              ],
              "type": "object",
              "properties": {
                "some": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/SelectionCriteria"
                  }
                }
              }
            },
            "SelectionCriteria": {
              "title": "SelectionCriteria",
              "type": "object",
              "properties": {
                "consistsOf": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Criteria"
                  }
                },
                "domain": {
                  "type": "string"
                },
                "omits": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Criteria"
                  }
                }
              }
            },
            "Criteria": {
              "title": "Criteria",
              "type": "object",
              "properties": {
                "expression": {
                  "type": "string"
                }
              }
            }
          }
        }
      }
        """.trimIndent()
    println(openApi)
}