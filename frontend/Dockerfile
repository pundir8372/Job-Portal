# --------------- Stage 1 -----------------------
FROM node:21 as frontend-builder


WORKDIR /app


COPY package*.json .


RUN npm i


COPY . .


# ------------------ Stage 2 -------------------

FROM node:21-slim


WORKDIR /app


COPY --from=frontend-builder /app .


EXPOSE 5173


CMD ["npm" , "run" , "dev" , "--" ,  "--host"]

