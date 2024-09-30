FROM node:20.17.0-alpine

WORKDIR /app
COPY frontend/package.json /app
RUN npm install --legacy-peer-deps
COPY frontend/. /app
RUN npm run build
RUN npm install -g serve

EXPOSE 7072

CMD serve -s build -l 7072
