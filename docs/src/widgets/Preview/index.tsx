import React from 'react';
import styles from './index.module.css';

export const Preview = ({children, imageUrl, width, height}) => (
  <div className={styles.container} >
    <div className={styles.code}>
      {children}
    </div>
    <img
      className={styles.img}
      src={imageUrl}
      width={width}
      height={height}
      alt=""
      loading="lazy" />
  </div>
);
