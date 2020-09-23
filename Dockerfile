FROM airhacks/glassfish
COPY ./target/JavaEESampleWithTest.war ${DEPLOYMENT_DIR}
