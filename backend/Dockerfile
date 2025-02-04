# ----------- Stage 1 -------------------------

FROM node:21 as backend-builder


WORKDIR /app


COPY . .



RUN npm i


# ---------------- Stage 2 ---------------------

FROM node:21-slim


WORKDIR /app


COPY --from=backend-builder /app .


EXPOSE 8000


CMD ["npm" , "run" , "dev"]
